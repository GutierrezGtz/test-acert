package com.project.acerttest.protocol;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	public BadRequestException(String string) {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}