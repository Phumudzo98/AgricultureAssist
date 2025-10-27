package com.agriculture.project.service.initialization;

import com.agriculture.project.dto.CropDto;

import java.util.List;

public interface CropService {

    CropDto createCrop(CropDto cropDto, Long landId);

    List<CropDto> getAllCropsByLandId(Long landId);
    CropDto getCropById(Long id);
    Boolean deleteCropById(Long id);
    CropDto updateCrop(CropDto cropDto, Long id);
}
