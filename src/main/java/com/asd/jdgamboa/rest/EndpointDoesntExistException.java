package com.asd.jdgamboa.rest;

/**
 * @author Juan David
 * Excepción personalizada lanzada cuando se accede a un punto no existente en la API
 */
public class EndpointDoesntExistException extends RuntimeException {

	/**
	 * {@inheritDoc}
	 */
	public EndpointDoesntExistException() {
	}

	/**
	 * {@inheritDoc}
	 */
	public EndpointDoesntExistException(String arg0) {
		super(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	public EndpointDoesntExistException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * {@inheritDoc}
	 */
	public EndpointDoesntExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	/**
	 * {@inheritDoc}
	 */
	public EndpointDoesntExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
