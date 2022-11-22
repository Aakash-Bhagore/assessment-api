/**
 * 
 */
package com.assessment.api.dto;

import java.util.UUID;

import lombok.Data;

/**
 * @author System - 35
 *
 */
@Data
public class QuestionDTO {

	private UUID studentId;
	private String question;
	
}
