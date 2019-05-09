package com.asd.jdgamboa.service;

import java.util.List;

import com.asd.jdgamboa.entity.Empleado;

/**
 * Interfaz para el servicio de Empleados
 * @author Juan David
 */
public interface EmpleadoService {

	/**
	 * @return Lista de todos los empleados
	 */
	public List<Empleado> getEmpleados();

	/**
	 * @param empleado Objeto empleado que se desea guardad en la base de datos
	 */
	public void saveEmpleado(Empleado empleado);

	/**
	 * @param codEmpleado ID del empleado a referenciar
	 * @return Objeto Empleado tomado de la base de datos
	 */
	public Empleado getEmpleado(String codEmpleado);

	/**
	 * @param codEmpleado ID del empleado a eliminar
	 */
	public void deleteEmpleado(String codEmpleado);
	
}
