package com.weatherapp.weatherapp.transformer;

import com.weatherapp.weatherapp.domain.CityCoordinates;
import com.weatherapp.weatherapp.entity.GeocodingcoordinatesEntity;
import org.springframework.stereotype.Service;

@Service
public class GeocodingCoordinatesTransformer {

    public CityCoordinates transformToDomain(final GeocodingcoordinatesEntity entity){
        return CityCoordinates.builder()
                .latitude(entity.getLatitude())
                .longitude(entity.getLongitude())
                .build();
    }
}
