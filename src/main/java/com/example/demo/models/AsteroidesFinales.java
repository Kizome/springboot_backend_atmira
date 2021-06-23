package com.example.demo.models;

import java.time.LocalDate;

public class AsteroidesFinales {

	public String nombre;
	public double diametro;
	public String velocidad;
	public LocalDate fecha;
	public String planeta;

	public AsteroidesFinales() {
		
	}

	public AsteroidesFinales(String nombre, double diametro, String velocidad, LocalDate fecha, String planeta) {
		super();
		this.nombre = nombre;
		this.diametro = diametro;
		this.velocidad = velocidad;
		this.fecha = fecha;
		this.planeta = planeta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	public String getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(String velocidad) {
		this.velocidad = velocidad;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}

}
