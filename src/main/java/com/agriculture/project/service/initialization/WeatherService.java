package com.agriculture.project.service.initialization;

import java.util.Map;

public interface WeatherService {

    Map<String, Object> getFullForecast(Long id, String exclude);
    Map<String, Object> getDailyForecast(Long id);
    Map<String, Object> getHistoricalByTimestamp(Long id, long timestamp);
    Map<String, Object> getDailySummary(Long id, String date);
    Map<String, Object> getWeatherOverview(Long id);
    Map<String, Object> getHourlyForecast(Long id);

}
