package com.weatherapp.weatherapp.controller;

import com.weatherapp.weatherapp.domain.WeatherRequestDetails;
import com.weatherapp.weatherapp.entity.WeatherResponse;
import com.weatherapp.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WeatherController {

    private WeatherService weatherService;
    @Autowired
    public WeatherController(final WeatherService weatherService){
        this.weatherService=weatherService;
    }

   /* @GetMapping("/weather/{city}")
    public @ResponseBody WeatherResponse weather(@PathVariable("city")String city) throws Exception {
       final WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
               .city(city)
               .build();

       return weatherService.getWeather(weatherRequestDetails);
    }*/
   @GetMapping("/weather")
   public String showWeatherForm() {

       return "weatherForm";
   }
    @PostMapping("/weather")
    public String getWeather(@RequestParam("city") String city, Model model) {
        try {
            if (!isValidCityName(city)) {
                model.addAttribute("error", "Invalid city name. Please enter a valid city name.");
                return "weatherForm"; // Return the same form with an error message
            }
            WeatherRequestDetails weatherRequestDetails = WeatherRequestDetails.builder()
                    .city(city).build();
            WeatherResponse weatherResponse = weatherService.getWeather(weatherRequestDetails);
            model.addAttribute("weather", weatherResponse);
            return "weather";
        } catch (Exception e) {
            model.addAttribute("error", "Invalid city name. Please enter a valid city name.");
            return "weatherForm";
        }
    }

    private boolean isValidCityName(String city) {
        return city != null && city.matches("[a-zA-Z ]+");
    }
}
