package com.asd.jdgamboa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Juan David
 * Entidad para la base de datos. Maneja los empleados.
 */
@Entity
@Table(name="empleado")
public class Empleado {

	@Id
	@Column(name="cod_empleado")
	private String codEmpleado;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="apellido")
	private String apellido;
	
	public Empleado() {
		
	}

	public String getCodEmpleado() {
		return codEmpleado;
	}

	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + codEmpleado + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
		
}





