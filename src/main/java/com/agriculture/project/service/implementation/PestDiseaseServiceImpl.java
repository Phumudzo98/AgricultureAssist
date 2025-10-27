package com.agriculture.project.service.implementation;

import com.agriculture.project.dto.PestDiseaseDto;
import com.agriculture.project.mapper.PestDiseaseMapper;
import com.agriculture.project.model.Crop;
import com.agriculture.project.model.PestDisease;
import com.agriculture.project.repository.CropRepository;
import com.agriculture.project.repository.PestDiseaseRepository;
import com.agriculture.project.service.initialization.PestDiseaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PestDiseaseServiceImpl implements PestDiseaseService {

    @Autowired
    private PestDiseaseRepository pestDiseaseRepository;
    private final CropRepository cropRepository;
    private final PestDiseaseMapper mapper;
    @Autowired
    private PestDiseaseMapper pestDiseaseMapper;


    @Override
    public PestDiseaseDto createPestDisease(PestDisease pestDisease, Long id) {

        Optional<Crop> crops = cropRepository.findById(id);

        if (crops.isPresent()) {
            Crop crop = crops.get();

            pestDisease.setCrop(crop);

            return pestDiseaseMapper.toDto(pestDiseaseRepository.save(pestDisease));
        }

        return null;
    }

    @Override
    public List<PestDiseaseDto> getByCrop(Long cropId) {
        return pestDiseaseMapper.toDtoList(pestDiseaseRepository.findByCropId(cropId));
    }

    @Override
    public PestDiseaseDto getById(Long id) {

        return mapper.toDto(pestDiseaseRepository.findById(id).orElse(null));

    }

    @Override
    public PestDiseaseDto updatePestDisease(Long id, PestDisease updated) {

        PestDisease pestDisease = pestDiseaseRepository.findById(id).get();

        if(pestDisease!=null) {
            pestDisease.setName(updated.getName());
            pestDisease.setNotes(updated.getNotes());
            pestDisease.setType(updated.getType());
            pestDisease.setActionTaken(updated.getActionTaken());
            pestDisease.setSeverity(updated.getSeverity());


            return mapper.toDto(pestDiseaseRepository.save(pestDisease));
        }
        return null;
    }

    @Override
    public Boolean delete(Long id) {

        PestDisease pestDisease = pestDiseaseRepository.findById(id).get();

        if(pestDisease!=null) {
            pestDiseaseRepository.delete(pestDisease);
            return true;
        }

        return false;

    }
}
