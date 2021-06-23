package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
	public Astrologia astrologia = new Astrologia();
	public PlanetaPerdido perdido = new PlanetaPerdido();

	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * Metodo principal que será el encargado del llamado de metodos para el tratamiento de datos extraidos de la
	 * api de la nasa.
	 * @param planet Planeta que se quiere consultar (solo conuslta la tierra al ser una api NEO (Near Earth Objects))
	 * @return Devuelve un objeto que será transformado en un JSON para su visualización
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	@RequestMapping("/asteroids")
	Object name(@RequestParam String planet) throws JsonMappingException, JsonProcessingException {
		if (planet.equals("earth")) {
			calculaFechas();

			Asteroid forNow = restTemplate.getForObject(
					url + "start_date=" + start_date + "&end_date=" + end_date + "&api_key=" + api_key, Asteroid.class);

			// Recorre cada dia encontrado
			forNow.getNearEarthObjects().forEach((dia, neos) -> {

				ArrayList<NearEarthObject> ListadoNeos = new ArrayList<>(neos);

				astrologia.compruebaAsteroides(ListadoNeos);

				astrologia.ordenaAsteroides();

				// Recorre los asteroides de cada dia
				for (int i = 0; i < ListadoNeos.size(); i++) {
					astrologia.asteroideMasGrande(ListadoNeos.get(i));
				}

			});

			return astrologia.cinturonDeAsteroides();
		} else {
			perdido.setMensaje("Lo siento, el planeta " + planet + " no está contemplado en esta versión.");
			return perdido;
		}
	}
	
	
	
	/**
	 * Metodo encargado de extraer la fecha del sistema y sumar 7 dias para su posterior consulta en la API de la NASA
	 */
	private void calculaFechas() {

		Date hoy = new Date();
		Date sietedias = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(hoy);
		c.add(Calendar.DATE, 7);
		sietedias = c.getTime();
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		start_date = formateador.format(hoy);
		end_date = formateador.format(sietedias);
	}

}