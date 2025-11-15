package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.FarmController;
import com.agriculture.project.dto.ChatResponse;
import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.dto.FarmOverviewDto;
import com.agriculture.project.dto.LandDetailsDto;
import com.agriculture.project.mapper.FarmMapper;
import com.agriculture.project.service.ChatGptService;
import com.agriculture.project.service.initialization.FarmService;
import com.agriculture.project.service.initialization.GeminiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FarmControllerImpl implements FarmController {

    private final FarmService farmService;
    private final FarmMapper farmMapper;
    private final ChatGptService chatGptService;
    private final GeminiService geminiService;


    @Override
    public FarmDto createFarm(String farmName, String farmType, String farmLocation, String farmDescription, double size, String metrics, String city, String landDetailsJson, MultipartFile image) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        List<LandDetailsDto> landDetails = Arrays.asList(
                mapper.readValue(landDetailsJson, LandDetailsDto[].class)
        );


        FarmDto farmDto = new FarmDto();
        farmDto.setFarmName(farmName);
        farmDto.setFarm_type(farmType);
        farmDto.setFarm_location(farmLocation);
        farmDto.setFarm_description(farmDescription);
        farmDto.setSize(size);
        farmDto.setMetrics(metrics);
        farmDto.setCity(city);
        farmDto.setLandDetails(landDetails);

        if (image != null && !image.isEmpty()) {
            farmDto.setFileType(image.getContentType());
            farmDto.setImage(image.getBytes());
        }


        return farmMapper.toDto(farmService.createFarm(farmDto));
    }

    @Override
    public FarmOverviewDto farmOverview(Long farmId) {
        return farmService.getFarmOverview(farmId);
    }

    @Override
    public List<FarmDto> getFarms() {
        return farmMapper.toDtoList(farmService.getFarms());
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
        return farmMapper.toDtoList(farmService.searchFarm(name));
    }

    @Override
    public FarmDto updateFarm(FarmDto farmDto) {
        return farmMapper.toDto(farmService.updateFarm(farmDto));
    }
}
