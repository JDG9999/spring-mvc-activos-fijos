package com.asd.jdgamboa.service;

import java.util.List;

import com.asd.jdgamboa.entity.Empleado;

public interface EmpleadoService {

	public List<Empleado> getEmpleados();

	public void saveEmpleado(Empleado empleado);

	public Empleado getEmpleado(String codEmpleado);

	public void deleteEmpleado(String codEmpleado);
	
}
