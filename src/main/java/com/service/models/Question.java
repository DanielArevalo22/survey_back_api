package com.service.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_question")
	private int idQuestion;
	@Column(name = "question")
	private String question;
	@Column(name = "id_survey")
	private int idSurvey;
	@Column(name = "id_section")
	private int idSection;
	@Column(name = "principal")
	private String principal;
	

	public Question() {

	}

	public Question(int idQuestion, String question, int idSurvey, int idSection, String principal) {
		super();
		this.idQuestion = idQuestion;
		this.question = question;
		this.idSurvey = idSurvey;
		this.idSection = idSection;
		this.principal = principal;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
	}

	public int getIdSection() {
		return idSection;
	}

	public void setIdSection(int idSection) {
		this.idSection = idSection;
	}

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

}
