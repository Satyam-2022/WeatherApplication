package com.weatherapp.weatherapp.entity;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherResponse {

    private String weather;
    private String details;
    private double temp;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;
}
