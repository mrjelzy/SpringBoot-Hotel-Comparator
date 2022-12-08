package com.example.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class AgencyNotFoundException extends ResponseStatusException{

	private static final long serialVersionUID = 1L;

	public AgencyNotFoundException(String reason) {
		super(HttpStatus.NOT_FOUND, reason);
	}

}
