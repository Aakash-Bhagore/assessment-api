/**
 * 
 */
package com.assessment.api.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.api.entity.Assessment;

/**
 * @author 
 *
 */
public interface AssessmentRepository extends JpaRepository<Assessment, UUID>{

}
