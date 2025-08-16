package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.FarmController;
import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.mapper.FarmMapper;
import com.agriculture.project.service.initialization.FarmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FarmControllerImpl implements FarmController {

    private final FarmService farmService;
    private final FarmMapper farmMapper;


    @Override
    public FarmDto createFarm(FarmDto farmDto) {
        return farmMapper.toDto(farmService.createFarm(farmDto));
    }

    @Override
    public List<FarmDto> getFarms() {
        return List.of();
    }

    @Override
    public FarmDto getFarmById(int id) {
        return farmMapper.toDto(farmService.getFarmById(id));
    }

    @Override
    public boolean deleteFarm(int id) {
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
