package com.agriculture.project.service.implementation;

import com.agriculture.project.dto.GeminiResponseDto;
import com.agriculture.project.service.initialization.GeminiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import java.util.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GeminiServiceImpl implements GeminiService {

    @Value("${GEMINI_API_KEY}")
    private String apiKey;

    @Value("${gemini.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String analyzeImage(String prompt, MultipartFile file) throws Exception {

        String base64Image = Base64.getEncoder().encodeToString(file.getBytes());


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String url = apiUrl + "?key=" + apiKey;


        Map<String, Object> requestBody = new HashMap<>();
        List<Object> parts = new ArrayList<>();
        parts.add(Map.of("text", prompt));
        parts.add(Map.of("inlineData", Map.of(
                "mimeType", file.getContentType(),
                "data", base64Image
        )));

        requestBody.put("contents", List.of(Map.of("parts", parts)));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<GeminiResponseDto> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                GeminiResponseDto.class
        );


        if (response.getBody() != null &&
                response.getBody().getCandidates() != null &&
                !response.getBody().getCandidates().isEmpty()) {

            GeminiResponseDto.Candidate candidate = response.getBody().getCandidates().get(0);
            if (candidate.getContent() != null && candidate.getContent().getParts() != null &&
                    !candidate.getContent().getParts().isEmpty()) {
                return candidate.getContent().getParts().get(0).getText();
            }
        }

        return "No response from Gemini API";
    }
}
