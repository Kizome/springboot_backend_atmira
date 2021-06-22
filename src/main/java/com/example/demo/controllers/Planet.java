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
	public NearEarthObject[] asteroidesMasGrandes = new NearEarthObject[3];
	public boolean contieneNull = false;

	private RestTemplate restTemplate = new RestTemplate();

	@RequestMapping("/asteroids")
	Object name(@RequestParam String planet) throws JsonMappingException, JsonProcessingException {

		calculaFechas();

		Asteroid forNow = restTemplate.getForObject(
				url + "start_date=" + start_date + "&end_date=" + end_date + "&api_key=" + api_key, Asteroid.class);

		// Recorre cada dia encontrado
		forNow.getNearEarthObjects().forEach((dia, neos) -> {
			System.out.println("dia " + dia);

			ArrayList<NearEarthObject> ListadoNeos = new ArrayList<>(neos);

			compruebaAsteroides(ListadoNeos);

			ordenaAsteroides();

			// Recorre los asteroides de cada dia
			for (int i = 0; i < ListadoNeos.size(); i++) {

				asteroideMasGrande(ListadoNeos.get(i));
				/*
				 * System.out.println(ListadoNeos.get(i).getID());
				 * System.out.println(ListadoNeos.get(i).getIsPotentiallyHazardousAsteroid());
				 */
			}

		});

		return forNow;
	}

	/**
	 * 
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

	private void compruebaAsteroides(ArrayList<NearEarthObject> asteroides) {

		int contadorNull = 0;

		for (int i = 0; i < asteroidesMasGrandes.length; i++) {
			if (asteroidesMasGrandes[i] != null) {
				contieneNull = false;
			} else {
				contadorNull++;
			}
		}

		if (contadorNull == 3) {
			for (int i = 0; i < asteroidesMasGrandes.length; i++) {
				asteroidesMasGrandes[i] = asteroides.get(i);
			}
		}
	}

	private void ordenaAsteroides() {
		double mediaUno;
		double mediaDos;
		double mediaTres;
		NearEarthObject salva = new NearEarthObject();
		NearEarthObject salvaDos = new NearEarthObject();
		mediaUno = (asteroidesMasGrandes[0].getEstimatedDiameter().getKilometers().getEstimatedDiameterMin()
				+ asteroidesMasGrandes[0].getEstimatedDiameter().getKilometers().getEstimatedDiameterMax()) / 2;
		mediaDos = (asteroidesMasGrandes[1].getEstimatedDiameter().getKilometers().getEstimatedDiameterMin()
				+ asteroidesMasGrandes[1].getEstimatedDiameter().getKilometers().getEstimatedDiameterMax()) / 2;
		mediaTres = (asteroidesMasGrandes[2].getEstimatedDiameter().getKilometers().getEstimatedDiameterMin()
				+ asteroidesMasGrandes[2].getEstimatedDiameter().getKilometers().getEstimatedDiameterMax()) / 2;

		if (mediaUno > mediaTres && mediaTres > mediaDos) {
			salva = asteroidesMasGrandes[1];
			asteroidesMasGrandes[1] = asteroidesMasGrandes[2];
			asteroidesMasGrandes[2] = salva;
		} else if (mediaDos > mediaUno && mediaUno > mediaTres) {
			salva = asteroidesMasGrandes[0];
			asteroidesMasGrandes[0] = asteroidesMasGrandes[1];
			asteroidesMasGrandes[1] = salva;
		} else if (mediaDos > mediaTres && mediaTres > mediaUno) {
			salva = asteroidesMasGrandes[0];
			asteroidesMasGrandes[0] = asteroidesMasGrandes[1];
			asteroidesMasGrandes[1] = asteroidesMasGrandes[2];
			asteroidesMasGrandes[2] = salva;
		} else if (mediaTres > mediaUno && mediaUno > mediaDos) {
			salva = asteroidesMasGrandes[0];
			salvaDos = asteroidesMasGrandes[1];
			asteroidesMasGrandes[0] = asteroidesMasGrandes[2];
			asteroidesMasGrandes[1] = salva;
			asteroidesMasGrandes[2] = salvaDos;
		} else if (mediaTres > mediaDos && mediaDos > mediaUno) {
			salva = asteroidesMasGrandes[0];
			salvaDos = asteroidesMasGrandes[1];
			asteroidesMasGrandes[0] = asteroidesMasGrandes[2];
			asteroidesMasGrandes[1] = salvaDos;
			asteroidesMasGrandes[2] = salva;
		}

	}

	private void asteroideMasGrande(NearEarthObject ast) {
		double mediaUno;
		double mediaDos;
		double mediaTres;
		double mediaCuatro;
		mediaUno = (asteroidesMasGrandes[0].getEstimatedDiameter().getKilometers().getEstimatedDiameterMin()
				+ asteroidesMasGrandes[0].getEstimatedDiameter().getKilometers().getEstimatedDiameterMax()) / 2;
		mediaDos = (asteroidesMasGrandes[1].getEstimatedDiameter().getKilometers().getEstimatedDiameterMin()
				+ asteroidesMasGrandes[1].getEstimatedDiameter().getKilometers().getEstimatedDiameterMax()) / 2;
		mediaTres = (asteroidesMasGrandes[2].getEstimatedDiameter().getKilometers().getEstimatedDiameterMin()
				+ asteroidesMasGrandes[2].getEstimatedDiameter().getKilometers().getEstimatedDiameterMax()) / 2;
		mediaCuatro = (ast.getEstimatedDiameter().getKilometers().getEstimatedDiameterMin()
				+ ast.getEstimatedDiameter().getKilometers().getEstimatedDiameterMax()) / 2;

		if (mediaCuatro > mediaUno) {
			asteroidesMasGrandes[0] = ast;
		} else if (mediaCuatro > mediaDos) {
			asteroidesMasGrandes[1] = ast;
		} else if (mediaCuatro > mediaTres) {
			asteroidesMasGrandes[2] = ast;
		}

	}
}