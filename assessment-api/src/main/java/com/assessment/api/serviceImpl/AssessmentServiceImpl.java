/**
 * 
 */
package com.assessment.api.serviceImpl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.api.dto.AssessmentDTO;
import com.assessment.api.entity.Assessment;
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
        log.info("saveUpdateUser method started User name :: "+ assessmentDTO.getAssessmentName());
        Assessment assessment = modelMapper.map(assessmentDTO, Assessment.class);
        Assessment savedUser = assessmentRepository.saveAndFlush(assessment);
        AssessmentDTO savedAssessmentDTO = modelMapper.map(savedUser, AssessmentDTO.class);
        log.info("User Saved Successfully userId :: "+ savedUser.getAssessmentId());
		return savedAssessmentDTO;
	}

	@Override
	public List<AssessmentDTO> getAssessments() {
		log.info("getAssessments method started.");
		List<Assessment> assessments = assessmentRepository.findAll();
		List<AssessmentDTO> assessmentDTO = assessments.stream().map(assessment -> modelMapper.map(assessments, AssessmentDTO.class)).collect(Collectors.toList());
		log.info("getAssessments method completed total assessments :: "+ assessments.size());
		return assessmentDTO;
	}

	@Override
	public void removeAssessmentById(UUID assessmentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AssessmentDTO getAssessmentById(UUID assessmentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
