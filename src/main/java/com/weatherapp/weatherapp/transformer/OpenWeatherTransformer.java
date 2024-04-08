package com.weatherapp.weatherapp.transformer;

import com.weatherapp.weatherapp.domain.CityWeather;
import com.weatherapp.weatherapp.entity.OpenWeatherResponseEntity;
import com.weatherapp.weatherapp.entity.WeatherResponse;
import org.springframework.stereotype.Service;

@Service
public class OpenWeatherTransformer {

    public CityWeather transformToDomain(final OpenWeatherResponseEntity entity){
        return CityWeather.builder()
                .weather(entity.getWeather()[0].getMain())
                .details(entity.getWeather()[0].getDescription())
                .temp(entity.getMain().getTemp())
                .tempMin(entity.getMain().getTemp_min())
                .tempMax(entity.getMain().getTemp_max())
                .humidity(entity.getMain().getHumidity())
                .pressure(entity.getMain().getPressure())
                .build();
    }

    public WeatherResponse transformToEntity(final CityWeather cityWeather){

        return WeatherResponse.builder()
                .weather(cityWeather.getWeather())
                .details(cityWeather.getDetails())
                .temp(cityWeather.getTemp())
                .tempMin(cityWeather.getTempMin())
                .tempMax(cityWeather.getTempMax())
                .humidity(cityWeather.getHumidity())
                .pressure(cityWeather.getPressure())
                .build();
    }

}
