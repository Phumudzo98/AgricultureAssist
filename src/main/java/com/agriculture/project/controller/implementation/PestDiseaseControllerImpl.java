package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.PestDiseaseController;
import com.agriculture.project.dto.PestDiseaseDto;
import com.agriculture.project.mapper.PestDiseaseMapper;
import com.agriculture.project.model.PestDisease;
import com.agriculture.project.service.initialization.PestDiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PestDiseaseControllerImpl implements PestDiseaseController {

    private final PestDiseaseService pestDiseaseService;
    private PestDiseaseMapper mapper;

    @Override
    public PestDiseaseDto create(PestDisease pestDisease, Long cropId) {
        return pestDiseaseService.createPestDisease(pestDisease, cropId);
    }

    @Override
    public PestDiseaseDto getById(Long id) {
        return pestDiseaseService.getById(id);
    }

    @Override
    public List<PestDiseaseDto> getByCrop(Long cropId) {
        return pestDiseaseService.getByCrop(cropId);
    }

    @Override
    public PestDiseaseDto update(Long id, PestDisease pestDisease) {
        return pestDiseaseService.updatePestDisease(id, pestDisease);
    }

    @Override
    public Boolean delete(Long id) {
        return pestDiseaseService.delete(id);
    }
}
