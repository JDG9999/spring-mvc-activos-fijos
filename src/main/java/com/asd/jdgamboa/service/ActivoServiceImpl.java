package com.asd.jdgamboa.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.asd.jdgamboa.dao.ActivoDAO;
import com.asd.jdgamboa.entity.Activo;

@Service
public class ActivoServiceImpl implements ActivoService {

	// need to inject customer dao
	@Autowired
	private ActivoDAO ActivoDAO;
	
	@Override
	@Transactional
	public List<Activo> getActivos() {
		return ActivoDAO.getActivos();
	}

	@Override
	@Transactional
	public void saveActivo(Activo activo) {
		ActivoDAO.saveActivo(activo);
	}
	
	@Override
	@Transactional
	public void updateActivo(Activo activo) {
		ActivoDAO.updateActivo(activo);
	}

	@Override
	@Transactional
	public Activo getActivo(String serial) {
		return ActivoDAO.getActivo(serial);
	}
	
	@Override
	@Transactional
	public List<Activo> getActivosPorTipo(String tipo) {
		return ActivoDAO.getActivosPorTipo(tipo);
	};
	
	@Override
	@Transactional
	public List<Activo> getActivosPorFechaCompra(Calendar fechaCompra) {
		return ActivoDAO.getActivosPorFechaCompra(fechaCompra);
	};

	@Override
	@Transactional
	public void deleteActivo(String serial) {
		ActivoDAO.deleteActivo(serial);
	}
	
}





