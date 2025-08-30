package com.agriculture.project.controller.initialization;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@RequestMapping("/weather")
public interface WeatherController {

    @GetMapping("/forecast/{id}")
    Map<String, Object> getFullForecast(@PathVariable Long id);

    @GetMapping("/hourly/{id}")
    Map<String, Object> getHourlyForecast(@PathVariable Long id);

    @GetMapping("/daily/{id}")
    Map<String, Object> getDailyForecast(@PathVariable Long id);

    @GetMapping("/historical/{id}")
    Map<String, Object> getHistoricalByTimestamp(@PathVariable Long id, @RequestParam long timestamp);

    @GetMapping("/daily-summary/{id}")
    Map<String, Object> getDailySummary(@PathVariable Long id, @RequestParam  String date);

    @GetMapping("/overview/{id}")
    Map<String, Object> getWeatherOverview(@PathVariable Long id);

}
