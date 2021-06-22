package com.example.demo.models;

import java.util.Date;

public class DangerousAsteroids {

	public String nombre;
	public double diametro;
	public String velocidad;
	public Date fecha;
	public String planeta;

	public DangerousAsteroids() {
		
	}

	public DangerousAsteroids(String nombre, float diametro, String velocidad, Date fecha, String planeta) {
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getPlaneta() {
		return planeta;
	}

	public void setPlaneta(String planeta) {
		this.planeta = planeta;
	}

}
