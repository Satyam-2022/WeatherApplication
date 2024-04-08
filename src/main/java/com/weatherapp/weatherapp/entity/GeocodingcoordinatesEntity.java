package com.weatherapp.weatherapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodingcoordinatesEntity {

    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("lon")
    private String longitude;

}
