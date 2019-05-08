package com.asd.jdgamboa.service;

import java.util.Calendar;
import java.util.List;

import com.asd.jdgamboa.entity.Activo;

public interface ActivoService {

	public List<Activo> getActivos();

	public void saveActivo(Activo activo);
	
	public void updateActivo(Activo activo);

	public Activo getActivo(String serial);
	
	public List<Activo> getActivosPorTipo(String tipo);
	
	public List<Activo> getActivosPorFechaCompra(Calendar fechaCompra);

	public void deleteActivo(String serial);
	
}
