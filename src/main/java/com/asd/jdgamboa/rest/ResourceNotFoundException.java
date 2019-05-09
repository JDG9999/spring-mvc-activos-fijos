package com.asd.jdgamboa.rest;

/**
 * @author Juan David
 * Excepción personalizada lanzada cuando no hay resultados para una búsqueda
 */
public class ResourceNotFoundException extends RuntimeException {

	/**
	 * {@inheritDoc}
	 */
	public ResourceNotFoundException() {
	}

	/**
	 * {@inheritDoc}
	 */
	public ResourceNotFoundException(String arg0) {
		super(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	public ResourceNotFoundException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	public ResourceNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	public ResourceNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
