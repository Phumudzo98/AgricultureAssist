package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.FarmController;
import com.agriculture.project.dto.ChatResponse;
import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.mapper.FarmMapper;
import com.agriculture.project.service.ChatGptService;
import com.agriculture.project.service.initialization.FarmService;
import com.agriculture.project.service.initialization.GeminiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FarmControllerImpl implements FarmController {

    private final FarmService farmService;
    private final FarmMapper farmMapper;
    private final ChatGptService chatGptService;
    private final GeminiService geminiService;


    @Override
    public FarmDto createFarm(FarmDto farmDto) {
        return farmMapper.toDto(farmService.createFarm(farmDto));
    }

    @Override
    public List<FarmDto> getFarms() {
        return List.of();
    }

    @Override
    public String analyzeImage(String prompt, MultipartFile file) throws Exception {
        return geminiService.analyzeImage(prompt, file);
    }

    @Override
    public FarmDto getFarmById(Long id) {
        return farmMapper.toDto(farmService.getFarmById(id));
    }

    private final ChatGptService aiService;

    @Override
    public String chatWithAi(String message, MultipartFile file) {
        try {
            if (file != null && !file.isEmpty()) {
                String base64Image = chatGptService.uploadImage(file);
                message += "\n[Attached image in Base64: " + base64Image + "]";
            }
            return chatGptService.chat(message, file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to process uploaded file", e);
        }
    }

    @Override
    public boolean deleteFarm(Long id) {
        return farmService.deleteFarm(id);
    }

    @Override
    public List<FarmDto> searchFarm(String name) {
        return List.of();
    }

    @Override
    public FarmDto updateFarm(FarmDto farmDto) {
        return farmMapper.toDto(farmService.updateFarm(farmDto));
    }
}
