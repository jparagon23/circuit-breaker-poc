package com.arquitectura.circuitbreker.controller;

import com.arquitectura.circuitbreker.model.Country;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {
    @Autowired
    private RestTemplate restTemplate;
    private final String COUNTRY_API= "https://restcountries.com/v3.1/";

    @GetMapping("/{capital}")
    @CircuitBreaker(name = "countryByCapital", fallbackMethod = "fallBackCountry")
    public List<Country> getCountryByName(@PathVariable String capital){

        String url = COUNTRY_API + "capital/" + capital;
        ResponseEntity<List<Country>> responseEntity = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Country>>() {}
        );

        return responseEntity.getBody();

    }

    public List<Country> fallBackCountry(String capital, Throwable throwable) {
        return Collections.emptyList();
    }
}
