package com.assessment.api.service;

import java.util.List;
import java.util.UUID;

import com.assessment.api.dto.QuestionDTO;

public interface QuestionService {

	QuestionDTO saveUpdateQuestion(QuestionDTO questionDTO);

    List<QuestionDTO> getQuestions();

    void removeQuestionById(UUID id);

    QuestionDTO getQuestionById(UUID id);
}
