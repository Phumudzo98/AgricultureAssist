package com.agriculture.project.service.initialization;


import com.agriculture.project.model.PestDisease;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PestDiseaseService {

    public PestDisease createPestDisease(PestDisease pestDisease, Long id);
    public List<PestDisease> getByCrop(Long cropId);
    public PestDisease getById(Long id);
    public PestDisease updatePestDisease(Long id, PestDisease updated);
    public Boolean delete(Long id);

}
