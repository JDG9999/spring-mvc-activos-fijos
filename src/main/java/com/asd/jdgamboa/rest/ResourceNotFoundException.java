package com.asd.jdgamboa.rest;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException() {
	}

	public ResourceNotFoundException(String arg0) {
		super(arg0);
	}

	public ResourceNotFoundException(Throwable arg0) {
		super(arg0);
	}

	public ResourceNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ResourceNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
