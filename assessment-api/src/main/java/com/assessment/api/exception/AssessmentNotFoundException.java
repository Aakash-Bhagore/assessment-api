/**
 * 
 */
package com.assessment.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author 
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AssessmentNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public AssessmentNotFoundException() {
		super();
	}
	public AssessmentNotFoundException(String message) {
		super(message);
	}

	
}
