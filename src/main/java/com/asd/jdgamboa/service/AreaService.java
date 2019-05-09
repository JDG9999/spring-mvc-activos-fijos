package com.asd.jdgamboa.service;

import java.util.List;

import com.asd.jdgamboa.entity.Area;

/**
 * Interfaz para el servicio de Áreas
 * @author Juan David
 */
public interface AreaService {

	/**
	 * @return Lista de todas las áreas
	 */
	public List<Area> getAreas();

	/**
	 * @param area El objeto Area que se desea salvar en la base de datos
	 */
	public void saveArea(Area area);

	/**
	 * @param codArea ID del área a referenciar
	 * @return Objeto Area tomado de la base de datos
	 */
	public Area getArea(String codArea);

	/**
	 * @param codArea ID del área a eliminar
	 */
	public void deleteArea(String codArea);
	
}
