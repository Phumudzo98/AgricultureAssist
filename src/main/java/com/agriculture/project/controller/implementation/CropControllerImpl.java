package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.CropController;
import com.agriculture.project.service.initialization.CropService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class CropControllerImpl implements CropController {

    private final CropService cropService;
}
