package com.asd.jdgamboa.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asd.jdgamboa.entity.Activo;
import com.asd.jdgamboa.entity.Area;
import com.asd.jdgamboa.entity.Empleado;
import com.asd.jdgamboa.service.ActivoService;
import com.asd.jdgamboa.service.AreaService;
import com.asd.jdgamboa.service.EmpleadoService;

@RestController
@RequestMapping("/api")
public class ApiRestController {
	
	@Autowired
	private ActivoService activoService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private AreaService areaService;
	
	@GetMapping("/activos")
	public List<Activo> getActivos() {
		return activoService.getActivos();
	}
	
	@PostMapping("/activos")
	public Activo addActivo(@RequestBody Activo nuevoActivo) {
		if (nuevoActivo.getEstado() == null) {
			nuevoActivo.setEstado("activo");
		}
		if (nuevoActivo.tieneNullInvalido()) {
			throw new InvalidDataException("Algún valor obligatorio es nulo");
		} else if (nuevoActivo.getFechaBaja() != null) {
			if (nuevoActivo.getFechaBaja().compareTo(nuevoActivo.getFechaCompra()) < 0) {
				throw new InvalidDataException("El argumento de fecha de baja ingresado no es válido");
			}
		} 
		try {
			activoService.saveActivo(nuevoActivo);
		} catch (DataIntegrityViolationException e) {
			throw new InvalidDataException("La petición no es válida. El serial o código de inventario están repetidos");
		} 
		return nuevoActivo;
	}
	
	@PutMapping("/activos")
	public Activo updateActivo(@RequestBody Activo modActivo) {
		if (modActivo.tieneNullInvalido()) {
			throw new InvalidDataException("Algún valor obligatorio es nulo");
		} else if (modActivo.getFechaBaja() != null) {
			if (modActivo.getFechaBaja().compareTo(modActivo.getFechaCompra()) < 0) {
				throw new InvalidDataException("El argumento de fecha de baja ingresado no es válido");
			}
		} 
		try {
			activoService.updateActivo(modActivo);
		} catch (DataIntegrityViolationException e) {
			throw new InvalidDataException("La petición no es válida. El serial o código de inventario están repetidos");
		} 
		return modActivo;
	}
	
	@GetMapping("/activos/serial/{serial}")
	public Activo getActivo(@PathVariable String serial) {
		Activo activo = activoService.getActivo(serial);
		if (activo == null) {
			throw new ResourceNotFoundException("Activo no encontrado");
		}
		return activo;
	}
	
	@GetMapping("/activos/tipo/{tipo}")
	public List<Activo> getActivosPorTipo(@PathVariable String tipo) {
		List<Activo> activos = activoService.getActivosPorTipo(tipo);
		if (activos == null) {
			throw new ResourceNotFoundException("No existen activos de este tipo");
		}
		return activos;
	}
	
	@GetMapping("/activos/fecha-compra/{fecha}")
	public List<Activo> getActivosPorFechaCompra(@PathVariable String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = sdf.parse(fecha);
		} catch (ParseException e) {
			throw new InvalidDataException("El argumento ingresado no es válido"); 
		}
		Calendar fechaC = Calendar.getInstance();
		fechaC.setTime(date);
		List<Activo> activos = activoService.getActivosPorFechaCompra(fechaC);
		if (activos == null) {
			throw new ResourceNotFoundException("No existen activos comprados en esta fecha");
		}
		return activos;
	}
	
	@GetMapping("/empleados")
	public List<Empleado> getEmpleados() {
		return empleadoService.getEmpleados();
	}
	
	@GetMapping("/areas")
	public List<Area> getAreas() {
		return areaService.getAreas();
	}
	
	@GetMapping("/**")
	public void defaultPath() {
		throw new EndpointDoesntExistException("Endpoint no existe en la API");
	}

}
