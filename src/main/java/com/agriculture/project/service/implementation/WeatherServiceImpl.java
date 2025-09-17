package com.agriculture.project.service.implementation;

import com.agriculture.project.model.Farm;
import com.agriculture.project.repository.FarmRepository;
import com.agriculture.project.service.initialization.WeatherService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private final FarmRepository farmRepository;


    @Value("${OpenWeatherAPI}")
    private String apiKey;

    private static final String GEO_URL = "http://api.openweathermap.org/geo/1.0/direct";
    private static final String BASE_URL = "https://api.openweathermap.org/data/3.0/onecall";

    private final RestTemplate restTemplate = new RestTemplate();

    public WeatherServiceImpl(FarmRepository farmRepository) {
        this.farmRepository = farmRepository;
    }


    private double[] getLatLon(String city) {
        String url = String.format("%s?q=%s&limit=1&appid=%s", GEO_URL, city, apiKey);
        Map<String, Object>[] geoData = restTemplate.getForObject(url, Map[].class);

        if (geoData == null || geoData.length == 0) {
            throw new RuntimeException("City not found: " + city);
        }

        double lat = ((Number) geoData[0].get("lat")).doubleValue();
        double lon = ((Number) geoData[0].get("lon")).doubleValue();
        return new double[]{lat, lon};
    }


    @Override
    public Map getFullForecast(Long id, String exclude) {
        return farmRepository.findById(id)
                .map(farm -> {
                    double[] coords = getLatLon(farm.getCity());

                    String url = String.format(
                            "%s?lat=%f&lon=%f&units=metric&appid=%s%s",
                            BASE_URL, coords[0], coords[1], apiKey,
                            (exclude != null && !exclude.isEmpty()) ? "&exclude=" + exclude : ""
                    );

                    return restTemplate.getForObject(url, Map.class);
                })
                .orElseThrow(() -> new RuntimeException("Farm not found"));
    }




    @Override
    public Map<String, Object> getHourlyForecast(Long id) {

        return getFullForecast(id, "current,daily,minutely,alerts");
    }




    @Override
    public Map<String, Object> getDailyForecast(Long id) {
        return getFullForecast(id, "current,hourly,minutely,alerts");
    }


    @Override
    public Map<String, Object> getHistoricalByTimestamp(Long id, long timestamp) {

        Optional<Farm> farm = farmRepository.findById(id);

        if (farm.isPresent()) {
            Farm f = farm.get();

            double[] coords = getLatLon(f.getCity());
            String url = String.format("%s/timemachine?lat=%f&lon=%f&dt=%d&appid=%s",
                    BASE_URL, coords[0], coords[1], timestamp, apiKey);

            return restTemplate.getForObject(url, Map.class);

        }

        return Collections.emptyMap();

    }


    @Override
    public Map<String, Object> getDailySummary(Long id, String date) {

        Optional<Farm> farm = farmRepository.findById(id);

        if (farm.isPresent()) {
            Farm f = farm.get();

            double[] coords = getLatLon(f.getCity());
            String url = String.format("%s/day_summary?lat=%f&lon=%f&date=%s&appid=%s",
                    BASE_URL, coords[0], coords[1], date, apiKey);

            return restTemplate.getForObject(url, Map.class);
        }

        return Collections.emptyMap();
    }


    @Override
    public Map<String, Object> getWeatherOverview(Long id) {

        Optional<Farm> farm = farmRepository.findById(id);

        if (farm.isPresent()) {

            double[] coords = getLatLon(farm.get().getCity());
            String url = String.format("%s/overview?lat=%f&lon=%f&appid=%s",
                    BASE_URL, coords[0], coords[1], apiKey);

            return restTemplate.getForObject(url, Map.class);

        }


        return Collections.emptyMap();

    }
}
