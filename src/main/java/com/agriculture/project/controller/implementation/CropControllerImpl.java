package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.CropController;
import com.agriculture.project.dto.AddCropDto;
import com.agriculture.project.dto.CropDto;
import com.agriculture.project.service.initialization.CropService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class CropControllerImpl implements CropController {

    private final CropService cropService;

    @Override
    public CropDto addCrop(CropDto cropDto, Long landId) {

        return cropService.createCrop(cropDto, landId);
    }

    @Override
    public CropDto cropDetails(Long id) {

        return cropService.getCropById(id);
    }

    @Override
    public List<CropDto> cropByLand(Long landId) {


        return ;
    }
}
