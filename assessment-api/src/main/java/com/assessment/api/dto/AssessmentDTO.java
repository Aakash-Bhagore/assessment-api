/**
 * 
 */
package com.assessment.api.dto;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author 
 *
 */
@Data
public class AssessmentDTO {

	private UUID assessmentId;
	private String assessmentName;
	private List<QuestionDTO> questions;
}
