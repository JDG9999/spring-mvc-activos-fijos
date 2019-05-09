package com.asd.jdgamboa.rest;

/**
 * @author Juan David
 * Excepción personalizada lanzada cuando se agregan datos no válidos a una petición
 */
public class InvalidDataException extends RuntimeException {

	/**
	 * {@inheritDoc}
	 */
	public InvalidDataException() {
	}

	/**
	 * {@inheritDoc}
	 */
	public InvalidDataException(String arg0) {
		super(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	public InvalidDataException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	public InvalidDataException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	public InvalidDataException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
