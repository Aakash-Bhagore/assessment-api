package com.assessment.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.api.dto.QuestionDTO;
import com.assessment.api.response.ResponseHandler;
import com.assessment.api.service.QuestionService;

@RestController
public class questionController {
	
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("question")
	public ResponseEntity<Object> createQuestion(@RequestBody QuestionDTO questionDTO) {
		try {			
			return ResponseHandler.generateResponse("success", HttpStatus.OK, questionService.saveUpdateQuestion(questionDTO));
		} catch (Exception ex) {
			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	
	@GetMapping("question/{id}")
	public ResponseEntity<Object> getQuestionDetail(@PathVariable String questionId) {
		try {
			return ResponseHandler.generateResponse("success", HttpStatus.OK, questionService.getQuestionById(UUID.fromString(questionId)));
		} catch (Exception ex) {			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	
	@DeleteMapping("question/{id}")
	public ResponseEntity<Object> deleteQuestion(@PathVariable String questionId) {
		try {	
			questionService.removeQuestionById(UUID.fromString(questionId));
			return ResponseHandler.generateResponse("success", HttpStatus.OK, "Successfully Deleted");
		} catch (Exception ex) {
			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
	@PutMapping("question")
	public ResponseEntity<Object> updateQuestion(@RequestBody QuestionDTO questionDTO) {
		try {				
			return ResponseHandler.generateResponse("success", HttpStatus.OK, questionService.saveUpdateQuestion(questionDTO));
		} catch (Exception ex) {			
			return ResponseHandler.generateResponse("error", HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
		}	
	} 
};
