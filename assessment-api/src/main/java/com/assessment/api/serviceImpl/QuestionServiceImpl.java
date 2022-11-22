/**
 * 
 */
package com.assessment.api.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.api.dto.QuestionDTO;
import com.assessment.api.exception.QuestionNotFoundException;
import com.assessment.api.repository.QuestionRepository;
import com.assessment.api.service.QuestionService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 
 *
 */

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public QuestionDTO saveUpdateQuestion(QuestionDTO questionDTO) {
		log.info("saveUpdateQuestion() method started");
		Question question = modelMapper.map(questionDTO, Question.class);
		Question savedQuestion = questionRepository.saveAndFlush(question);
		QuestionDTO savedQuestionDTO = modelMapper.map(savedQuestion, QuestionDTO.class);
		log.info("Question Saved Successfully");
		return savedQuestionDTO;
	}

	@Override
	public List<QuestionDTO> getQuestions() {
		log.info("getQuestions() method started");
		List<Question> questions = questionRepository.findAll();
		List<QuestionDTO> questionsDTO = questions.stream().map(question -> modelMapper.map(questions, QuestionDTO.class)).collect(Collectors.toList());
		log.info("getQuestions() method finished successfully");
		return questionsDTO;
	}

	@Override
	public void removeQuestionById(UUID questionId) {
		log.info("removeQuestionById() method started");
		questionRepository.deleteById(questionId);
		log.info("removeQuestionById() method finished successfully");
	}

	@Override
	public QuestionDTO getQuestionById(UUID questionId) {
		log.info("getQuestionById() method started successfully");
		Optional<Question> questionOptional = questionRepository.findById(questionId);
		if(questionOptional.isEmpty()) {
			log.error("getQuestionById:: question not found with id ::"+questionId);
			throw new QuestionNotFoundException("getQuestionById:: question not found with id ::"+questionId);
		}
		Question question = questionOptional.get();
		QuestionDTO questionDTO = modelMapper.map(question, QuestionDTO.class);
		log.info("getQuestionById() method finished successfully");
		return questionDTO;
	}

}
