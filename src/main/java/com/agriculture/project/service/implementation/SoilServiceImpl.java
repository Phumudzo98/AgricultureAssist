package com.agriculture.project.service.implementation;

import com.agriculture.project.dto.SoilDto;
import com.agriculture.project.mapper.SoilMapper;
import com.agriculture.project.model.LandDetails;
import com.agriculture.project.model.Soil;
import com.agriculture.project.repository.LandDetailsRepository;
import com.agriculture.project.repository.SoilRepository;
import com.agriculture.project.service.initialization.SoilService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SoilServiceImpl implements SoilService {

    private final SoilRepository soilRepository;
    private final SoilMapper soilMapper;
    private final LandDetailsRepository landDetailsRepository;

    @Override
    public SoilDto createSoilRecord(SoilDto soil, Long landId) {

        Optional<LandDetails> landDetails = landDetailsRepository.findById(landId);

        if (landDetails.isPresent()) {
            Soil entitySoil = soilMapper.toEntity(soil);

            entitySoil.setLandDetails(landDetails.get());
            return soilMapper.toDto(soilRepository.save(entitySoil));
        }

        return null;
    }

    @Override
    public SoilDto getById(Long id) {
        Optional<Soil> soil = soilRepository.findById(id);

        return soil.map(soilMapper::toDto).orElse(null);

    }

    @Override
    public List<SoilDto> getByLand(Long landId) {
        return soilMapper.toDtos(soilRepository.findByLandDetailsId(landId));
    }

    @Override
    public SoilDto updateSoil(Long id, SoilDto updated) {

        Optional<Soil> soil = soilRepository.findById(id);

        if (soil.isPresent()) {
            Soil soilEntity = soilMapper.toEntity(updated);
            soilEntity.setId(id);
            return soilMapper.toDto(soilRepository.save(soilEntity));

        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {

        Optional<Soil> soil = soilRepository.findById(id);

        if (soil.isPresent()) {
            soilRepository.delete(soil.get());
            return true;
        }
        return false;
    }
}
