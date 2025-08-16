package com.agriculture.project.service.initialization;

import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.model.Farm;

import java.util.List;

public interface FarmService {

    List<Farm> getFarms();
    Farm getFarmById(Long id);
    Farm createFarm(FarmDto farm);
    Farm updateFarm(FarmDto farm);
    boolean deleteFarm(Long id);
    List<Farm> searchFarm(String search);
}
