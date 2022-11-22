/**
 * 
 */
package com.assessment.api.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class QuestionDTO {

	private UUID questionId;
	private String question;
	
}
