package com.assessment.api.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "questions")
public class Question implements Serializable {

	private static final Long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private UUID questionId;
	private String question;

}
