package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.SoilController;
import com.agriculture.project.dto.SoilDto;
import com.agriculture.project.mapper.SoilMapper;
import com.agriculture.project.service.initialization.SoilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SoilControllerImpl implements SoilController {

    private final SoilService soilService;
    private final SoilMapper soilMapper;


    @Override
    public SoilDto create(SoilDto soil, Long id) {
        return soilMapper.toDto(soilService.createSoilRecord(soil, id));
    }

    @Override
    public SoilDto getById(Long id) {
        return soilService.getById(id);
    }

    @Override
    public List<SoilDto> getByLand(Long landId) {
        return soilService.getByLand(landId);
    }

    @Override
    public SoilDto update(Long id, SoilDto soil) {
        return soilService.updateSoil(id, soil);
    }

    @Override
    public Boolean delete(Long id) {
        return soilService.delete(id);
    }
}
