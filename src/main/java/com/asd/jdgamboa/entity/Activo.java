package com.asd.jdgamboa.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="activo")
public class Activo {

	@Id
	@Column(name="serial")
	private String serial;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="peso")
	private int peso;
	
	@Column(name="alto")
	private int alto;
	
	@Column(name="ancho")
	private int ancho;
	
	@Column(name="largo")
	private int largo;
	
	@Column(name="color")
	private String color;
	
	@Column(name="cod_inventario")
	private String codInventario;
	
	@Column(name="valor_compra")
	private BigDecimal valorCompra;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_compra")
	private Calendar fechaCompra;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="fecha_baja")
	private Calendar fechaBaja;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="asignacion_empleado")
	private String asignacionEmpleado;
	
	@Column(name="asignacion_area")
	private String asignacionArea;
		
	public Activo() {
		
	}
	
	public boolean tieneNullInvalido() {
		boolean resultado = false;
		// check all mandatory values
		if (serial == null || nombre == null || descripcion == null || tipo == null ||
		codInventario == null || valorCompra == null || fechaCompra == null || estado == null) {
			resultado = true;
		}
		// check constraint 'asignacion'
		if (asignacionArea == null && asignacionEmpleado == null) {
			resultado = true;
		}
		return resultado;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getLargo() {
		return largo;
	}

	public void setLargo(int largo) {
		this.largo = largo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCodInventario() {
		return codInventario;
	}

	public void setCodInventario(String codInventario) {
		this.codInventario = codInventario;
	}

	public BigDecimal getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}

	public Calendar getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Calendar fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public Calendar getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Calendar fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getAsignacionEmpleado() {
		return asignacionEmpleado;
	}

	public void setAsignacionEmpleado(String asignacionEmpleado) {
		this.asignacionEmpleado = asignacionEmpleado;
	}

	public String getAsignacionArea() {
		return asignacionArea;
	}

	public void setAsignacionArea(String asignacionArea) {
		this.asignacionArea = asignacionArea;
	}

	@Override
	public String toString() {
		return "Activo [id=]";
	}
	
	public enum Estado {
		ACTIVO,
		DADO_DE_BAJA,
		EN_REPARACION,
		DISPONIBLE,
		ASIGNADO
	}
		
}





