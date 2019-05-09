package com.asd.jdgamboa.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

/**
 * @author Juan David
 * Controlador para la API
 */
@RestController
@RequestMapping("/api")
public class ApiRestController {
	
	@Autowired
	private ActivoService activoService;
	@Autowired
	private EmpleadoService empleadoService;
	@Autowired
	private AreaService areaService;
	
	private static final Logger logger = LogManager.getLogger(ApiRestController.class);
	
	/**
	 * @return La ejecución del servicio de activos de retornar una lista.
	 */
	@GetMapping("/activos")
	public List<Activo> getActivos() {
		logger.info("GET - Petición para obtener la lista de activos");
		return activoService.getActivos();
	}
	
	/**
	 * @param nuevoActivo El objeto de tipo activo que se desea agregar
	 * @return El mismo objeto agregado si la operación fue exitosa
	 */
	@PostMapping("/activos")
	public Activo addActivo(@RequestBody Activo nuevoActivo) {
		logger.info("POST - Petición para almacenar un nuevo activo");
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
	
	/**
	 * @param modActivo El objeto de tipo activo que se desea modificar
	 * @return El objeto con las características modificadas
	 */
	@PutMapping("/activos")
	public Activo updateActivo(@RequestBody Activo modActivo) {
		logger.info("PUT - Petición para actualizar un activo");
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
	
	/**
	 * @param serial Serial del activo que se desea referenciar
	 * @return Activo referenciado por su serial
	 */
	@GetMapping("/activos/serial/{serial}")
	public Activo getActivo(@PathVariable String serial) {
		logger.info("GET - Petición para obtener un archivo por su serial");
		Activo activo = activoService.getActivo(serial);
		if (activo == null) {
			throw new ResourceNotFoundException("Activo no encontrado");
		}
		return activo;
	}
	
	/**
	 * @param tipo Tipo de activos
	 * @return Lista de activos correspondientes a ese tipo
	 */
	@GetMapping("/activos/tipo/{tipo}")
	public List<Activo> getActivosPorTipo(@PathVariable String tipo) {
		logger.info("GET - Petición para obtener un archivo por su tipo");
		List<Activo> activos = activoService.getActivosPorTipo(tipo);
		if (activos == null) {
			throw new ResourceNotFoundException("No existen activos de este tipo");
		}
		return activos;
	}
	
	/**
	 * @param fecha Fecha de compra de los activos
	 * @return Lista de activos comprados en esa fecha
	 */
	@GetMapping("/activos/fecha-compra/{fecha}")
	public List<Activo> getActivosPorFechaCompra(@PathVariable String fecha) {
		logger.info("GET - Petición para obtener un archivo por su fecha de compra");
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
	
	/**
	 * @return Lista de empleados
	 */
	@GetMapping("/empleados")
	public List<Empleado> getEmpleados() {
		logger.info("GET - Petición para obtener la lista de empleados");
		return empleadoService.getEmpleados();
	}
	
	/**
	 * @return Lista de áreas
	 */
	@GetMapping("/areas")
	public List<Area> getAreas() {
		logger.info("GET - Petición para obtener la lista de areas");
		return areaService.getAreas();
	}
	
	/**
	 * Mapeo de todas las URI que no correspondan a uno de los casos anteriores
	 */
	@GetMapping("/**")
	public void defaultPath() {
		throw new EndpointDoesntExistException("Endpoint no existe en la API");
	}

}
