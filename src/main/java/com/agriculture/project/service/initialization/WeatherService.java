package com.agriculture.project.service.initialization;

import java.util.Map;

public interface WeatherService {

    Map<String, Object> getCurrentWeather(String city);
    Map<String, Object>[] getCoordinates(String city);
    Map<String, Object> getSevenDayForecast(String city);
    Map<String, Object> getHourlyForecast(String city);

}
