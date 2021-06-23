package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.*;

/**
 * @author omarj
 *
 */
public class Astrologia {

	public NearEarthObject[] asteroidesMasGrandes = new NearEarthObject[3];
	public boolean contieneNull = false;
	public AsteroidesFinales[] asteroidesFinales = new AsteroidesFinales[3];

	public Astrologia() {
	}

	/**
	 * Metodo encargado de inicializar el array de objetos recibidos.
	 * 
	 * @param asteroides: Lista de asteroides recibidos.
	 */
	public void compruebaAsteroides(ArrayList<NearEarthObject> asteroides) {

		int contadorNull = 0;
		int contadorTrue = 0;

		for (int i = 0; i < asteroidesMasGrandes.length; i++) {
			if (asteroidesMasGrandes[i] != null) {
				contieneNull = false;
			} else {
				contadorNull++;
			}
		}

		if (contadorNull == 3) {
			for (int i = 0; i < asteroidesMasGrandes.length; i++) {
				if (asteroides.get(i).getIsPotentiallyHazardousAsteroid() == true) {
					asteroidesMasGrandes[i] = asteroides.get(i);
					contadorTrue++;
				}
			}
		}

		if (contadorTrue < 3) {
			for (int i = 0; i < asteroidesMasGrandes.length; i++) {
				asteroidesMasGrandes[i] = asteroides.get(i);
			}
		}
	}

	/**
	 * Metodo encargado de ordenar de mayor a menor tamaño los primeros asteroides
	 * guardados en @asteroidesMasGrandes
	 */
	public void ordenaAsteroides() {
		double mediaUno;
		double mediaDos;
		double mediaTres;
		NearEarthObject salva = new NearEarthObject();
		NearEarthObject salvaDos = new NearEarthObject();
		mediaUno = calculaTamaño(asteroidesMasGrandes[0]);
		mediaDos = calculaTamaño(asteroidesMasGrandes[1]);
		mediaTres = calculaTamaño(asteroidesMasGrandes[2]);

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

	/**
	 * Metodo encargado de ir comprobando uno a uno los asteroides recibidos y
	 * guardarlo en caso de ser mas grande que los que ya hay.
	 * 
	 * @param ast: Es el asteroide que se va a comprobar
	 */
	public void asteroideMasGrande(NearEarthObject ast) {
		double mediaUno;
		double mediaDos;
		double mediaTres;
		double mediaCuatro;
		mediaUno = calculaTamaño(asteroidesMasGrandes[0]);
		mediaDos = calculaTamaño(asteroidesMasGrandes[1]);
		mediaTres = calculaTamaño(asteroidesMasGrandes[2]);
		mediaCuatro = calculaTamaño(ast);

		if (mediaCuatro > mediaUno && ast.getIsPotentiallyHazardousAsteroid() == true) {
			asteroidesMasGrandes[0] = ast;
		} else if (mediaCuatro > mediaDos && ast.getIsPotentiallyHazardousAsteroid() == true) {
			asteroidesMasGrandes[1] = ast;
		} else if (mediaCuatro > mediaTres && ast.getIsPotentiallyHazardousAsteroid() == true) {
			asteroidesMasGrandes[2] = ast;
		}

	}

	/**
	 * Metodo encargado del calculo del tamaño medio de los objetos
	 * @param num Recime un asteroide completo para su procesamiento.
	 * @return Devuelve un double con el tamaño medio del asteroide
	 */
	public double calculaTamaño(NearEarthObject num) {
		return (num.getEstimatedDiameter().getKilometers().getEstimatedDiameterMin()
				+ num.getEstimatedDiameter().getKilometers().getEstimatedDiameterMax()) / 2;
	}

	/**
	 * Metodo encargado de dar forma al JSON que se va a mostrar como resultado
	 * @return Devuelve el objeto final que será mostrado al usuario con los 3 asteroides mas grandes y peligrosos
	 */
	public Object cinturonDeAsteroides() {
		for (int i = 0; i < asteroidesMasGrandes.length; i++) {
			asteroidesFinales[i] = new AsteroidesFinales(asteroidesMasGrandes[i].getName(),
					calculaTamaño(asteroidesMasGrandes[i]),
					buscaVelocidad(asteroidesMasGrandes[i].getCloseApproachData()),
					buscaDistancia(asteroidesMasGrandes[i].getCloseApproachData()),
					buscaPlaneta(asteroidesMasGrandes[i].getCloseApproachData()));
		}
		return asteroidesFinales;
	}

	/**
	 * Metodo encargado de extraer la velocidad del asteroide recibido
	 * @param velocidad Lista de velocidades del asteroide recibido
	 * @return Devuelve la velocidad
	 */
	public String buscaVelocidad(List<CloseApproachDatum> velocidad) {

		String kilometraje = "";

		for (int i = 0; i < velocidad.size(); i++) {
			kilometraje = velocidad.get(i).getRelativeVelocity().getKilometersPerHour() + "Km/h";
			break;
		}

		return kilometraje;
	}

	/**
	 * Metodo encargado de extraer la distancia del asteroide con el planeta recibido
	 * @param separado Lista de proximidades con el planeta
	 * @return Devuelve la distancia con el planeta
	 */
	public LocalDate buscaDistancia(List<CloseApproachDatum> separado) {

		LocalDate separacion = null;

		for (int i = 0; i < separado.size(); i++) {
			separacion = separado.get(i).getCloseApproachDate();
			break;
		}

		return separacion;
	}

	/**
	 * Metodo que extrae el planeta que esta relacionado con el asteroide.
	 * @param planeta Recibe el listado de datos relacionados con la distancia y el planeta
	 * @return Devuelve el planeta en el que posiblemente colisione el asteroide
	 */
	public String buscaPlaneta(List<CloseApproachDatum> planeta) {

		String planetario = "";

		for (int i = 0; i < planeta.size(); i++) {
			planetario = planeta.get(i).getOrbitingBody().toString();
			break;
		}

		return planetario;
	}

}
