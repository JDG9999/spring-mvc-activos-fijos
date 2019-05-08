package com.asd.jdgamboa.rest;

public class InvalidDataException extends RuntimeException {

	public InvalidDataException() {
	}

	public InvalidDataException(String arg0) {
		super(arg0);
	}

	public InvalidDataException(Throwable arg0) {
		super(arg0);
	}

	public InvalidDataException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidDataException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
