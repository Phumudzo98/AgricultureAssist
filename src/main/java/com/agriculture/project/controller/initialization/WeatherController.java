package com.agriculture.project.controller.initialization;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/weather")
public interface WeatherController {

    @GetMapping("/current/{city}")
    Map<String, Object> getWeather(@PathVariable String city);

    @GetMapping("/7day/{city}")
    public Map<String, Object> getSevenDayForecast(@PathVariable String city);

    @GetMapping("/hourly/{city}")
    public Map<String, Object> getHourlyForecast(@PathVariable String city);



}
