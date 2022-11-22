/**
 * 
 */
package com.assessment.api.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.api.dto.AssessmentDTO;
import com.assessment.api.entity.Assessment;
import com.assessment.api.exception.AssessmentNotFoundException;
import com.assessment.api.repository.AssessmentRepository;
import com.assessment.api.service.AssessmentService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 
 *
 */
@Service
@Slf4j
public class AssessmentServiceImpl implements AssessmentService{

	@Autowired
	private AssessmentRepository assessmentRepository;
	
	@Autowired
	private ModelMapper modelMapper; 
	
	@Override
	public AssessmentDTO saveUpdateAssessment(AssessmentDTO assessmentDTO) {
        log.info("saveUpdateAssessment() method started "+ assessmentDTO.getAssessmentName());
        Assessment assessment = modelMapper.map(assessmentDTO, Assessment.class);
        Assessment savedAssessment = assessmentRepository.saveAndFlush(assessment);
        AssessmentDTO savedAssessmentDTO = modelMapper.map(savedAssessment, AssessmentDTO.class);
        log.info("Assessment Saved Successfully :: "+ savedAssessment.getAssessmentId());
		return savedAssessmentDTO;
	}

	@Override
	public List<AssessmentDTO> getAssessments() {
		log.info("getAssessments() method started ");
		List<Assessment> assessments = assessmentRepository.findAll();
		List<AssessmentDTO> assessmentDTO = assessments.stream().map(assessment -> modelMapper.map(assessments, AssessmentDTO.class)).collect(Collectors.toList());
		log.info("getAssessments() method finished with total assessments "+ assessments.size());
		return assessmentDTO;
	}

	@Override
	public void removeAssessmentById(UUID assessmentId) {
		log.info("removeAssessmentById() method started with assessmentId "+ assessmentId);
        assessmentRepository.deleteById(assessmentId);
        log.info("removeAssessmentById() method deleted assessment successfully");
		
	}

	@Override
	public AssessmentDTO getAssessmentById(UUID assessmentId) {
		log.info("getAssessmentById() method started assessment id "+assessmentId);
        Optional<Assessment> assessmentOptional = assessmentRepository.findById(assessmentId);
        if(assessmentOptional.isEmpty()){
            log.error("getAssessmentById() assessment not found with id ::"+assessmentId);
            throw new AssessmentNotFoundException("getAssessmentById() assessment not found with id ::"+assessmentId);
        }
        Assessment assessment = assessmentOptional.get();
        AssessmentDTO assessmentDTO = modelMapper.map(assessment, AssessmentDTO.class);
        log.info("getAssessmentById() method finished successfully");
        return assessmentDTO;
	}

}
