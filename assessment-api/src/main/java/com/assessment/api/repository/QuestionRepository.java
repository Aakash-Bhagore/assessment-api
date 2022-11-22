/**
 * 
 */
package com.assessment.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.api.entity.Question;

/**
 * @author 
 *
 */
public interface QuestionRepository extends JpaRepository<Question, UUID>{

}
