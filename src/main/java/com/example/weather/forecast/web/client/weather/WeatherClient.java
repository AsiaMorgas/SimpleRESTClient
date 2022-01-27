package com.example.weather.forecast.web.client.weather;

import com.example.weather.forecast.model.WeatherDto;
import com.example.weather.forecast.web.client.weather.dto.OpenWeatherWeatherDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherClient {

    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "...";
    RestTemplate restTemplate = new RestTemplate();


    public WeatherDto getWeatherForCity(String city) {
        OpenWeatherWeatherDto openWeatherWeatherDto =
                callGetMethod("weather?q={city}&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherWeatherDto.class, city, API_KEY);
        return WeatherDto.builder()
                .temperature(openWeatherWeatherDto.getMain().getTemp())
                .humidity(openWeatherWeatherDto.getMain().getHumidity())
                .pressure(openWeatherWeatherDto.getMain().getPressure())
                .windSpeed(openWeatherWeatherDto.getWind().getSpeed())
                .build();
    }


    public WeatherDto getForecast(double lat, double lon) {
         OpenWeatherWeatherDto openWeatherWeatherDto =
                 callGetMethod(
                "onecall?lat={lat}&lon={lon}&exclude=minutely,hourly&appid={apiKey}&units=metric&lang=pl",
                OpenWeatherWeatherDto.class, lat, lon, API_KEY);
         return WeatherDto.builder()
                 .build();
    }

    private <T> T callGetMethod(String url , Class<T> responseType, Object...objects) {
        return restTemplate
                .getForObject(BASE_URL + url,
                        responseType, objects);
    }
}
