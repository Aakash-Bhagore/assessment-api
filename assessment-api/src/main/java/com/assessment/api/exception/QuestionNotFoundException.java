package com.assessment.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class QuestionNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public QuestionNotFoundException() {
		super();
	}
	public QuestionNotFoundException(String message) {
		super(message);
	}

}
