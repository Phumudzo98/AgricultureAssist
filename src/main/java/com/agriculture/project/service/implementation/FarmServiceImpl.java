package com.agriculture.project.service.implementation;

import com.agriculture.project.dto.FarmDto;
import com.agriculture.project.mapper.FarmMapper;
import com.agriculture.project.model.Farm;
import com.agriculture.project.repository.FarmRepository;
import com.agriculture.project.service.initialization.FarmService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmServiceImpl implements FarmService {

    private final FarmRepository farmRepository;
    private final FarmMapper farmMapper;

    public FarmServiceImpl(FarmRepository farmRepository, FarmMapper farmMapper) {
        this.farmRepository = farmRepository;
        this.farmMapper = farmMapper;
    }

    @Override
    public List<Farm> getFarms() {
        return farmRepository.findAll();
    }

    @Override
    public Farm getFarmById(int id) {
        return null;
    }

    @Override
    public Farm createFarm(FarmDto farm) {
        return null;
    }

    @Override
    public Farm updateFarm(FarmDto farm) {
        return null;
    }

    @Override
    public boolean deleteFarm(int id) {
        return false;
    }

    @Override
    public List<Farm> searchFarm(String search) {
        return List.of();
    }
}
