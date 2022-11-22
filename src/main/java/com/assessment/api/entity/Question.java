package com.assessment.api.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "questions")
public class Question {

	private UUID studentId;
	private String question;
	
}
