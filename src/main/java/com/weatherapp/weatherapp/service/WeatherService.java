package com.weatherapp.weatherapp.service;

import com.weatherapp.weatherapp.domain.CityCoordinates;
import com.weatherapp.weatherapp.domain.CityWeather;
import com.weatherapp.weatherapp.domain.WeatherRequestDetails;
import com.weatherapp.weatherapp.entity.OpenWeatherResponseEntity;
import com.weatherapp.weatherapp.entity.WeatherResponse;
import com.weatherapp.weatherapp.provider.GeocodingProvider;
import com.weatherapp.weatherapp.provider.WeatherProvider;
import com.weatherapp.weatherapp.transformer.GeocodingCoordinatesTransformer;
import com.weatherapp.weatherapp.transformer.OpenWeatherTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    private GeocodingProvider geocodingProvider;
    private GeocodingCoordinatesTransformer geocodingCoordinatesTransformer;
    private WeatherProvider weatherProvider;
    private OpenWeatherTransformer openWeatherTransformer;

    @Autowired
    public WeatherService(final GeocodingProvider geocodingProvider,
                          final GeocodingCoordinatesTransformer geocodingCoordinatesTransformer,
                          final WeatherProvider weatherProvider,
                          final OpenWeatherTransformer openWeatherTransformer){
        this.geocodingProvider=geocodingProvider;
        this.geocodingCoordinatesTransformer=geocodingCoordinatesTransformer;
        this.weatherProvider=weatherProvider;
        this.openWeatherTransformer=openWeatherTransformer;
    }
    public WeatherResponse getWeather(final WeatherRequestDetails weatherRequestDetails) throws Exception {
         final CityCoordinates cityCoordinates = geocodingCoordinatesTransformer
                 .transformToDomain(geocodingProvider.getCoordinates(weatherRequestDetails));

         final CityWeather cityWeather = openWeatherTransformer
                 .transformToDomain(weatherProvider.getWeather(cityCoordinates));

         return openWeatherTransformer.transformToEntity(cityWeather);
    }

}
