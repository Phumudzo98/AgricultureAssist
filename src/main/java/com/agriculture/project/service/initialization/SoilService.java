package com.agriculture.project.service.initialization;

import com.agriculture.project.dto.SoilDto;
import com.agriculture.project.model.Soil;

import java.util.List;

public interface SoilService {



    public SoilDto createSoilRecord(SoilDto soil, Long id);

    public SoilDto getById(Long id);

    public List<SoilDto> getByLand(Long landId);

    public SoilDto updateSoil(Long id, SoilDto updated);

    public Boolean delete(Long id);
}
