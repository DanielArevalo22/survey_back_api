package com.service.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "answers")
public class Answer {

	@Id
	@Column(name = "id_question")
	private int idQuestion;
	@Column(name = "id_survey")
	private int idSurvey;
	@Column(name = "id_participant")
	private String idParticipant;
	@Column(name = "score")
	private String score;

	public Answer() {

	}

	public Answer(int idQuestion, String idParticipant, String score, int idSurvey) {
		super();
		this.idQuestion = idQuestion;
		this.idParticipant = idParticipant;
		this.score = score;
		this.idSurvey = idSurvey;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public String getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(String idParticipant) {
		this.idParticipant = idParticipant;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public int getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
	}

}
