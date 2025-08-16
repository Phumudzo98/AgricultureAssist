package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.WeatherController;
import com.agriculture.project.service.initialization.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherControllerImpl implements WeatherController {

    private final WeatherService weatherService;
}
