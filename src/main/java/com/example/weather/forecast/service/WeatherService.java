package com.example.weather.forecast.service;

import com.example.weather.forecast.model.WeatherDto;
import com.example.weather.forecast.web.client.weather.WeatherClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {

    private WeatherClient weatherClient;

    public WeatherDto getWeather() {
        return weatherClient.getWeatherForCity("warszawa");
    }
}
