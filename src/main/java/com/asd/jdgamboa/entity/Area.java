package com.asd.jdgamboa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="area")
public class Area {

	@Id
	@Column(name="cod_area")
	private String codArea;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="ciudad")
	private String ciudad;
	
	public Area() {
		
	}

	public String getCodArea() {
		return codArea;
	}

	public void setCodArea(String codArea) {
		this.codArea = codArea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Area [id=" + codArea + ", nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}
		
}





