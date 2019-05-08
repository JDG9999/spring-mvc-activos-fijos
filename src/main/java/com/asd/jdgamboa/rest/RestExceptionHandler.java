package com.asd.jdgamboa.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(ResourceNotFoundException ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),
									ex.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(EndpointDoesntExistException ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
									ex.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(InvalidDataException ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
									ex.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(JsonParseException ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),
									ex.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(Exception ex) {
		ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
									ex.getMessage(),
									System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
