package com.asd.jdgamboa.service;

import java.util.Calendar;
import java.util.List;

import com.asd.jdgamboa.entity.Activo;

/**
 * Interfaz para el servicio de Activos
 * @author Juan David
 */
public interface ActivoService {

	/**
	 * @return Lista de todos los activos
	 */
	public List<Activo> getActivos();

	/**
	 * @param activo El objeto Activo que se desea salvar en la base de datos
	 */
	public void saveActivo(Activo activo);
	
	/**
	 * @param activo El objeto Activo que se desea modificar en la base de datos
	 */
	public void updateActivo(Activo activo);

	/**
	 * @param serial Serial del objeto a referenciar
	 * @return Objeto alimentado desde la base de datos 
	 */
	public Activo getActivo(String serial);
	
	/**
	 * @param tipo Tipo de activo 
	 * @return Lista de los activos pertenecientes a ese tipo
	 */
	public List<Activo> getActivosPorTipo(String tipo);
	
	/**
	 * @param fechaCompra Fecha en que se compró el activo
	 * @return Lista de los activos comprados en esa fecha
	 */
	public List<Activo> getActivosPorFechaCompra(Calendar fechaCompra);

	/**
	 * @param serial Serial del objeto a eliminar
	 */
	public void deleteActivo(String serial);
	
}
