package com.agriculture.project.service.implementation;

import com.agriculture.project.model.Crop;
import com.agriculture.project.model.LandDetails;
import com.agriculture.project.model.PestDisease;
import com.agriculture.project.repository.CropRepository;
import com.agriculture.project.repository.LandDetailsRepository;
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
    private CropRepository cropRepository;


    @Override
    public PestDisease createPestDisease(PestDisease pestDisease, Long id) {

        Optional<Crop> crops = cropRepository.findById(id);

        if (crops.isPresent()) {
            Crop crop = crops.get();

            pestDisease.setCrop(crop);

            return pestDiseaseRepository.save(pestDisease);
        }

        return null;
    }

    @Override
    public List<PestDisease> getByCrop(Long cropId) {
        return pestDiseaseRepository.findByCropId(cropId);
    }

    @Override
    public Optional<PestDisease> getById(Long id) {

        PestDisease pestDisease = null;
        return Optional.empty();
    }

    @Override
    public PestDisease updatePestDisease(Long id, PestDisease updated) {

        PestDisease pestDisease = pestDiseaseRepository.findById(id).get();

        if(pestDisease!=null) {

            return pestDisease;
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
