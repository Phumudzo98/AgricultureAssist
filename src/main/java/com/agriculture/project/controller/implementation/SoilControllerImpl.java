package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.SoilController;
import com.agriculture.project.service.initialization.SoilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SoilControllerImpl implements SoilController {

    private final SoilService soilService;

}
