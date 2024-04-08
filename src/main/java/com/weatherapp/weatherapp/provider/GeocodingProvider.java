package com.weatherapp.weatherapp.provider;

import com.weatherapp.weatherapp.domain.WeatherRequestDetails;
import com.weatherapp.weatherapp.entity.GeocodingcoordinatesEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GeocodingProvider {
    @Value("${api.key}")
    private String apikey;
    @Value("${geocoding.url}")
    private String geocodingUrl;

    public GeocodingcoordinatesEntity getCoordinates(final WeatherRequestDetails weatherRequestDetails) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        final ResponseEntity<GeocodingcoordinatesEntity[]> responseEntity;

        HttpEntity<String> requestEntity = new HttpEntity<>(null,null);

        UriComponents uriBuilder = UriComponentsBuilder.fromHttpUrl(geocodingUrl)
                .queryParam("q",weatherRequestDetails.getCity())
                .queryParam("limit",1)
                .queryParam("appid",apikey).build();

        try{
            responseEntity = restTemplate.exchange(uriBuilder.toUriString(),
                    HttpMethod.GET,
                    requestEntity,
                    GeocodingcoordinatesEntity[].class);
        }catch (HttpStatusCodeException e){
            throw new Exception(e.getMessage());
        }

        return responseEntity.getBody()[0];


    }

}
