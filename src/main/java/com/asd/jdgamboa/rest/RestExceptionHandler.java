package com.asd.jdgamboa.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;

/**
 * @author Juan David
 * Clase que maneja las excepciones dentro de la API
 */
@ControllerAdvice
public class RestExceptionHandler {
	
	/**
	 * @param ex Excepción por búsqueda sin resultados
	 * @return Respuesta de error 404 
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
									ex.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	/**
	 * @param ex Excepción por acceso a un endpoint inexistente
	 * @return Respuesta de error 400 
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(EndpointDoesntExistException ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
									ex.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * @param ex Excepción en la entrada de datos incorrectos
	 * @return Respuesta de error 400 
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(InvalidDataException ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
									ex.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * @param ex Excepción en la creación de objeto de tipo JSON dentro de una petición
	 * @return Respuesta de error 400 
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(JsonParseException ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
									ex.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * @param ex Excepción genérica no atrapada por alguno de los casos anteriores
	 * @return Respuesta de error 500
	 */
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
									ex.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
