package com.assessment.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.assessment.api.dto.AssessmentDTO;
import com.assessment.api.entity.Assessment;
import com.assessment.api.response.ResponseHandler;
import com.assessment.api.service.AssessmentService;

@Controller
public class assessmentController {
	
	@Autowired
	private AssessmentService assessmentService;
	
	@PostMapping("assessment")
	public ResponseEntity<Object> createAssessment(@RequestBody AssessmentDTO assessmentDTO) {
		try {
			return ResponseHandler.generateResponse("success", HttpStatus.OK, assessmentService.saveUpdateAssessment(assessmentDTO));
		} catch (Exception ex) {
			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	
	@GetMapping("assessment/{id}")
	public ResponseEntity<Object> getAssessmentDetail(@PathVariable String assessmentId) {
		try {
			return ResponseHandler.generateResponse("success", HttpStatus.OK, assessmentService.getAssessmentById(UUID.fromString(assessmentId)));
		} catch (Exception ex) {
			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	
	@DeleteMapping("assessment/{id}")
	public ResponseEntity<Object> deleteAssessment(@PathVariable String assessmentId) {
		try {	
			assessmentService.removeAssessmentById(UUID.fromString(assessmentId));
			return ResponseHandler.generateResponse("success", HttpStatus.OK, "Successfully Deleted");
		} catch (Exception ex) {
			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	@PutMapping("assessment")
	public ResponseEntity<Object> updateAssessment(@RequestBody AssessmentDTO assessmentDTO) {
		try {				
			return ResponseHandler.generateResponse("success", HttpStatus.OK, assessmentService.saveUpdateAssessment(assessmentDTO));
		} catch (Exception ex) {			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	
	
}
