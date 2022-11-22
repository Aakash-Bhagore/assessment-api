/**
 * 
 */
package com.assessment.api.service;

import java.util.List;
import java.util.UUID;

import com.assessment.api.dto.AssessmentDTO;

/**
 * @author 
 *
 */
public interface AssessmentService {

	AssessmentDTO saveUpdateAssessment(AssessmentDTO assessmentDTO);

    List<AssessmentDTO> getAssessments();

    void removeAssessmentById(UUID assessmentId);

    AssessmentDTO getAssessmentById(UUID assessmentId);
}
