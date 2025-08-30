package com.agriculture.project.controller.implementation;

import com.agriculture.project.controller.initialization.WeatherController;
import com.agriculture.project.service.initialization.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class WeatherControllerImpl implements WeatherController {

    private final WeatherService weatherService;


    @Override
    public Map<String, Object> getFullForecast(Long id) {
        return weatherService.getFullForecast(id, null);
    }

    @Override
    public Map<String, Object> getHourlyForecast(Long id) {
        return weatherService.getHourlyForecast(id);
    }

    @Override
    public Map<String, Object> getDailyForecast(Long id) {
        return weatherService.getDailyForecast(id);
    }

    @Override
    public Map<String, Object> getHistoricalByTimestamp(Long id, long timestamp) {
        return weatherService.getHistoricalByTimestamp(id, timestamp);
    }

    @Override
    public Map<String, Object> getDailySummary(Long id, String date) {
        return weatherService.getDailySummary(id, date);
    }

    @Override
    public Map<String, Object> getWeatherOverview(Long id) {
        return weatherService.getWeatherOverview(id);
    }
}
