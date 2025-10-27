package com.agriculture.project.service.initialization;


import com.agriculture.project.dto.PestDiseaseDto;
import com.agriculture.project.model.PestDisease;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PestDiseaseService {

    public PestDiseaseDto createPestDisease(PestDisease pestDisease, Long id);
    public List<PestDiseaseDto> getByCrop(Long cropId);
    public PestDiseaseDto getById(Long id);
    public PestDiseaseDto updatePestDisease(Long id, PestDisease updated);
    public Boolean delete(Long id);

}
