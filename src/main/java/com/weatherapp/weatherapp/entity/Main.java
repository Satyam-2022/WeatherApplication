package com.weatherapp.weatherapp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Main {
    @JsonProperty("temp")
    private double temp;
    @JsonProperty("temp_min")
    private double temp_min;
    @JsonProperty("temp_max")
    private double temp_max;
    @JsonProperty("pressure")
    private int pressure;
    @JsonProperty("humidity")
    private int humidity;
}
