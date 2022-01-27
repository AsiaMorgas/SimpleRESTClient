package com.example.weather.forecast.controller;

import com.example.weather.forecast.model.WeatherDto;
import com.example.weather.forecast.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherDto getWeather() {
        return weatherService.getWeather();

    }
}
