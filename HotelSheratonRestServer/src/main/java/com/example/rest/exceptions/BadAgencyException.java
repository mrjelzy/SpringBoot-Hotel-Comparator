package com.example.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BadAgencyException extends ResponseStatusException{

	private static final long serialVersionUID = 1L;

	public BadAgencyException(String reason) {
		super(HttpStatus.FORBIDDEN, reason);
	}

}
