package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
public class Planet {
    public String planetName = "";
    public String url = "https://api.nasa.gov/neo/rest/v1/feed?";
    public String start_date = "2020-09-09";
    public String end_date = "2020-09-16";
    public String api_key = "zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";

    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/asteroids")
    Object name(@RequestParam String planet) throws JsonMappingException, JsonProcessingException {

    	
    	System.out.println(planet);
        Asteroid forNow = restTemplate.getForObject("https://api.nasa.gov/neo/rest/v1/feed?start_date=2020-09-09&end_date=2020-09-16&api_key=DEMO_KEY", Asteroid.class);

        forNow.getNearEarthObjects().forEach((dia, neos) -> {
            System.out.println("dia " + dia);
            
            ArrayList<NearEarthObject> ListadoNeos = new ArrayList<>(neos);
            
            for (int i = 0; i < ListadoNeos.size(); i++) {
                System.out.println(ListadoNeos.get(i).getID());
                System.out.println(ListadoNeos.get(i).getIsPotentiallyHazardousAsteroid());
            }
            
        });
        return forNow;
    }
}