package com.asd.jdgamboa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asd.jdgamboa.dao.EmpleadoDAO;
import com.asd.jdgamboa.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	// need to inject customer dao
	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	@Override
	@Transactional
	public List<Empleado> getEmpleados() {
		return empleadoDAO.getEmpleados();
	}

	@Override
	@Transactional
	public void saveEmpleado(Empleado empleado) {
		empleadoDAO.saveEmpleado(empleado);
	}

	@Override
	@Transactional
	public Empleado getEmpleado(String codEmpleado) {
		return empleadoDAO.getEmpleado(codEmpleado);
	}

	@Override
	@Transactional
	public void deleteEmpleado(String codEmpleado) {
		empleadoDAO.deleteEmpleado(codEmpleado);
	}
	
}





