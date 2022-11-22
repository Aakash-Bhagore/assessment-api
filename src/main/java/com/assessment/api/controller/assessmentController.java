package com.assessment.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.assessment.api.entity.Assessment;
import com.assessment.api.response.ResponseHandler;

@Controller
public class assessmentController {

	@GetMapping("assessment/{id}")
	public ResponseEntity<Object> getAssessmentDetail(@PathVariable String assessmentId) {
		try {	
			
			return ResponseHandler.generateResponse("success", HttpStatus.OK, "");
		} catch (Exception ex) {
			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	
	@PostMapping("assessment")
	public ResponseEntity<Object> createAssessment(@RequestBody Assessment assessment) {
		try {	
			
			return ResponseHandler.generateResponse("success", HttpStatus.OK, assessment);
		} catch (Exception ex) {
			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	@DeleteMapping("assessment/{id}")
	public ResponseEntity<Object> deleteAssessment(@PathVariable String assessmentId) {
		try {	
			
			return ResponseHandler.generateResponse("success", HttpStatus.OK, "");
		} catch (Exception ex) {
			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	@PutMapping("assessment")
	public ResponseEntity<Object> showContestList(@RequestBody Assessment assessment) {
		try {	
			
			return ResponseHandler.generateResponse("success", HttpStatus.OK, assessment);
		} catch (Exception ex) {
			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	
	
}
