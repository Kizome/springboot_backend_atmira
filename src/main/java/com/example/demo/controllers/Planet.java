package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.Asteroids;

@RestController
public class Planet {

	public String planetName = "";
	public String url = "https://api.nasa.gov/neo/rest/v1/feed?";
	public String start_date = "2020-09-09";
	public String end_date = "2020-09-16";
	public String api_key = "zdUP8ElJv1cehFM0rsZVSQN7uBVxlDnu4diHlLSb";
	
	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/asteroids")
	Asteroids name(@RequestParam String planet ) {
		
		Asteroids asteroidsSummary = restTemplate.getForObject(url + "start_date=" + start_date 
				+ "&end_date=" + end_date + "&api_key=" + api_key, Asteroids.class);

		/*
		 * • nombre: Obtenido de "name", • diametro: Tamaño medio calculado 
		 * • velocidad: "close_approach_data:relative_velocity:kilometers_per_hour" 
		 * • fecha: "close_approach_data:close_approach_date" 
		 * • planeta: "close_approach_date:orbiting_body"
		 */

		return asteroidsSummary;
	}
}
