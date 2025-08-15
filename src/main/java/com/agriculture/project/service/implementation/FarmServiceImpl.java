package com.agriculture.project.service.implementation;

import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.service.initialization.FarmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {
    @Override
    public List<FarmDto> getFarms() {
        return List.of();
    }

    @Override
    public FarmDto getFarmById(int id) {
        return null;
    }

    @Override
    public FarmDto createFarm(FarmDto farm) {
        return null;
    }

    @Override
    public FarmDto updateFarm(FarmDto farm) {
        return null;
    }

    @Override
    public boolean deleteFarm(int id) {
        return false;
    }

    @Override
    public List<FarmDto> searchFarm(String search) {
        return List.of();
    }
}
