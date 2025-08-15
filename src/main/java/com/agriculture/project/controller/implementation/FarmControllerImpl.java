package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.FarmController;
import com.agriculture.project.dto.FarmDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FarmControllerImpl implements FarmController {

    @Override
    public FarmDto createFarm(FarmDto farmDto) {
        return null;
    }

    @Override
    public List<FarmDto> getFarms() {
        return List.of();
    }

    @Override
    public FarmDto getFarmById(int id) {
        return null;
    }

    @Override
    public boolean deleteFarm(int id) {
        return false;
    }

    @Override
    public List<FarmDto> searchFarm(String name) {
        return List.of();
    }
}
