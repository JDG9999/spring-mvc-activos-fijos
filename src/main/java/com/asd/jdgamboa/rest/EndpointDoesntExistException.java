package com.asd.jdgamboa.rest;

public class EndpointDoesntExistException extends RuntimeException {

	public EndpointDoesntExistException() {
	}

	public EndpointDoesntExistException(String arg0) {
		super(arg0);
	}

	public EndpointDoesntExistException(Throwable arg0) {
		super(arg0);
	}

	public EndpointDoesntExistException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EndpointDoesntExistException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
