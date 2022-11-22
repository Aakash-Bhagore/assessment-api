/**
 * 
 */
package com.assessment.api.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author 
 *
 */
@Data
@Entity
@Table(name = "assessments")
public class Assessment {

	private UUID assessmentId;
	private String assessmentName;
	private List<Question> questions;
}
