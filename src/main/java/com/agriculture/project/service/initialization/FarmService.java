package com.agriculture.project.service.initialization;

import com.agriculture.project.dto.FarmDto;

import java.util.List;

public interface FarmService {

    List<FarmDto> getFarms();
    FarmDto getFarmById(int id);
    FarmDto createFarm(FarmDto farm);
    FarmDto updateFarm(FarmDto farm);
    boolean deleteFarm(int id);
    List<FarmDto> searchFarm(String search);
}
