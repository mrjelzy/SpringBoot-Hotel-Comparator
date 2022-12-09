package com.example.rest.exceptions;

public class AgencyNotFoundException extends AgencyException {

	private static final long serialVersionUID = 1L;

	public AgencyNotFoundException() {
		super();
	}

	public AgencyNotFoundException(String message) {
		super(message);
	}

}
