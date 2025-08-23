package com.agriculture.project.service.implementation;

import com.agriculture.project.service.initialization.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${OpenWeatherAPI}")
    private String apiKey;

    @Value("${OpenWeatherURL}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();


    @Override
    public Map<String, Object> getCurrentWeather(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city + "&appid=" + apiKey + "&units=metric";
        return restTemplate.getForObject(url, Map.class);
    }

    @Override
    public Map<String, Object>[] getCoordinates(String city) {
        String url = "http://api.openweathermap.org/geo/1.0/direct?q="
                + city + "&limit=1&appid=" + apiKey;
        return restTemplate.getForObject(url, Map[].class);
    }

    @Override
    public Map<String, Object> getSevenDayForecast(String city) {
        Map<String, Object>[] geoData = getCoordinates(city);
        if (geoData.length == 0) {
            throw new RuntimeException("City not found: " + city);
        }

        double lat = (Double) geoData[0].get("lat");
        double lon = (Double) geoData[0].get("lon");

        String url = apiUrl + "?lat=" + lat + "&lon=" + lon
                + "&exclude=minutely,hourly,alerts&appid="
                + apiKey + "&units=metric";

        return restTemplate.getForObject(url, Map.class);
    }

    @Override
    public Map<String, Object> getHourlyForecast(String city) {
        Map<String, Object>[] geoData = getCoordinates(city);
        if (geoData.length == 0) {
            throw new RuntimeException("City not found: " + city);
        }

        double lat = (Double) geoData[0].get("lat");
        double lon = (Double) geoData[0].get("lon");

        String url = apiUrl + "?lat=" + lat + "&lon=" + lon
                + "&exclude=daily,minutely,alerts&appid="
                + apiKey + "&units=metric";

        return restTemplate.getForObject(url, Map.class);
    }
}
