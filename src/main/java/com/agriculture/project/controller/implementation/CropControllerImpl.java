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
    public String addCrop(AddCropDto cropDto) {
        return "";
    }

    @Override
    public CropDto cropDetails(int id) {
        return null;
    }

    @Override
    public List<CropDto> cropByLand(int landId) {
        return List.of();
    }
}
