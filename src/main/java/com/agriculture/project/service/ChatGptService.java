package com.agriculture.project.service;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;


@Service
public class ChatGptService {

    @Value("${openai.api.key}")
    private String openAiApiKey;

    private final WebClient webClient = WebClient.create();
    private final int MAX_RETRIES = 3;
    private final long RETRY_DELAY_MS = 2000; // 2 seconds

    // Send message to ChatGPT (with optional file)
    public String chat(String message, MultipartFile file) throws IOException {
        Map<String, Object> request = Map.of(
                "model", "text-davinci-003",
                "messages", List.of(Map.of("role", "user", "content", message))
        );

        // If file is present, convert to Base64 and append to message
        if (file != null && !file.isEmpty()) {
            String base64 = Base64.getEncoder().encodeToString(file.getBytes());
            // You can append the image as text to the message
            message += "\n[Image in Base64]: " + base64;
            request = Map.of(
                    "model", "gpt-3.5-turbo",
                    "messages", List.of(Map.of("role", "user", "content", message))
            );
        }

        for (int attempt = 1; attempt <= MAX_RETRIES; attempt++) {
            try {
                Map<String, Object> response = webClient.post()
                        .uri("https://api.openai.com/v1/chat/completions")
                        .header("Authorization", "Bearer " + openAiApiKey)
                        .bodyValue(request)
                        .retrieve()
                        .bodyToMono(Map.class)
                        .block();

                List<Map<String, Object>> choices = (List<Map<String, Object>>) response.get("choices");
                return (String) ((Map<String, Object>) choices.get(0).get("message")).get("content");

            } catch (WebClientResponseException.TooManyRequests e) {
                System.out.println("Rate limit hit. Attempt " + attempt + "/" + MAX_RETRIES);
                if (attempt == MAX_RETRIES) {
                    throw new RuntimeException("Exceeded OpenAI free-tier limit. Try again later.");
                }
                try {
                    Thread.sleep(RETRY_DELAY_MS);
                } catch (InterruptedException ignored) {}
            }
        }

        throw new RuntimeException("Failed to call OpenAI API.");
    }

    // Optional: separate method for just uploading image
    public String uploadImage(MultipartFile file) throws IOException {
        return Base64.getEncoder().encodeToString(file.getBytes());
    }
}


