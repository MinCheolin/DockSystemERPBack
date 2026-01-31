package com.example.docksystem_erp.service.Home;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String apiKey = "1f1866c1ed19cebb93c990f1ee480adf";

    public Map<String, Object> getWeather(double lat, double lon){
        String currentUrl = String.format(
        "https://api.openweathermap.org/data/2.5/weather?lat=%f&lon=%f&appid=%s&units=metric&lang=kr",
        lat, lon, apiKey
        );

        String forecastUrl = String.format(
        "https://api.openweathermap.org/data/2.5/forecast?lat=%f&lon=%f&appid=%s&units=metric&lang=kr",
        lat, lon, apiKey
        );

        Map<String,Object> current = restTemplate.getForObject(currentUrl,Map.class);
        Map<String,Object> forecast = restTemplate.getForObject(forecastUrl,Map.class);

        Map<String,Object> result = new HashMap<>();
        result.put("current",current);
        result.put("forecast",forecast);

        String cityName = (String) current.get("name");
        result.put("city",cityName);

        return result;
    }

}
