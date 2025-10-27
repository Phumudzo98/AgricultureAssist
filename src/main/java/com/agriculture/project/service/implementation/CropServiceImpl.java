package com.agriculture.project.service.implementation;

import com.agriculture.project.dto.CropDto;
import com.agriculture.project.mapper.CropMapper;
import com.agriculture.project.model.Crop;
import com.agriculture.project.model.LandDetails;
import com.agriculture.project.repository.CropRepository;
import com.agriculture.project.repository.LandDetailsRepository;
import com.agriculture.project.service.initialization.CropService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;
    private final CropMapper cropMapper;
    private final LandDetailsRepository landDetailsRepository;

    public CropServiceImpl(CropRepository cropRepository, CropMapper cropMapper, LandDetailsRepository landDetailsRepository) {
        this.cropRepository = cropRepository;
        this.cropMapper = cropMapper;
        this.landDetailsRepository = landDetailsRepository;
    }

    @Override
    public CropDto createCrop(CropDto cropDto, Long landId) {

        Optional<LandDetails> landDetails = landDetailsRepository.findById(landId);

        if (landDetails.isPresent()) {
            Crop crop = cropMapper.toCrop(cropDto);
            crop.setLandDetails(landDetails.get());

            return cropMapper.toCropDto(cropRepository.save(crop));
        }
        return null;
    }

    @Override
    public List<CropDto> getAllCropsByLandId(Long landId) {
        Optional<LandDetails> landDetails = landDetailsRepository.findById(landId);
        if (landDetails.isPresent()) {
            return cropMapper.toCropDtos(cropRepository.findByLandDetailsId(landId));
        }

        return List.of();
    }

    @Override
    public CropDto getCropById(Long id) {
       Optional<Crop> crop = cropRepository.findById(id);

       if (crop.isPresent()) {
           return cropMapper.toCropDto(crop.get());
       }

       return null;
    }

    @Override
    public Boolean deleteCropById(Long id) {
        Optional<Crop> crop = cropRepository.findById(id);

        if (crop.isPresent()) {
            cropRepository.delete(crop.get());
            return true;
        }
        return false;
    }

    @Override
    public CropDto updateCrop(CropDto cropDto, Long id) {

        Optional<Crop> crop = cropRepository.findById(id);
        if (crop.isPresent()) {
            Crop cropEntity = cropMapper.toCrop(cropDto);
            cropEntity.setId(id);
            return cropMapper.toCropDto(cropRepository.save(cropEntity));
        }
        return null;
    }
}
