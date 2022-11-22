/**
 * 
 */
package com.assessment.api.repository;

import java.util.UUID;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 
 *
 */
public interface QuestionRepository extends JpaRepository<Question, UUID>{

}
