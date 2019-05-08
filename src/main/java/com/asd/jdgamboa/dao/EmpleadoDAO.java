package com.asd.jdgamboa.dao;

import java.util.List;

import com.asd.jdgamboa.entity.Empleado;

public interface EmpleadoDAO {

	public List<Empleado> getEmpleados();

	public void saveEmpleado(Empleado empleado);

	public Empleado getEmpleado(String codEmpleado);

	public void deleteEmpleado(String codEmpleado);
	
}
