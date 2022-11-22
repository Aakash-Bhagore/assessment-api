/**
 * 
 */
package com.assessment.api.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author 
 *
 */
@Entity
@Table(name = "assessments")
public class Assessment implements Serializable {

	private static final Long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private UUID assessmentId;
	private String assessmentName;
	@OneToMany(targetEntity = Question.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Question> questions;

	public Assessment() {}

	public Assessment(UUID assessmentId, String assessmentName, List<Question> questions) {
		super();
		this.assessmentId = assessmentId;
		this.assessmentName = assessmentName;
		this.questions = questions;
	}

	public UUID getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(UUID assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Assessment [assessmentId=" + assessmentId + ", assessmentName=" + assessmentName + ", questions="
				+ questions + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(assessmentId, assessmentName, questions);
	}

	@Override
	public boolean equals(Object obj) {
		try {
			UUID assessmentId = this.assessmentId;
			String assessmentName = this.assessmentName;
			Assessment assessment = (Assessment) obj;

			if(assessmentName.equals(assessment.getAssessmentName()) && assessmentId == assessment.getAssessmentId()) {
				return true;
			} else return false;
		}catch(ClassCastException e)
		{
			return false;
		}
		catch(NullPointerException e)
		{
			return false;
		}
	}
}
