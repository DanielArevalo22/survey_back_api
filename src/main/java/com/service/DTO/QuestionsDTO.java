package com.service.DTO;

public class QuestionsDTO {

	private String question;
	private String isPrincipal;
	private int idQuestion;
	private int score;

	public QuestionsDTO() {

	}

	public QuestionsDTO(String question, String isPrincipal, int idQuestion, int score) {
		super();
		this.question = question;
		this.isPrincipal = isPrincipal;
		this.idQuestion = idQuestion;
		this.score = score;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getIsPrincipal() {
		return isPrincipal;
	}

	public void setIsPrincipal(String isPrincipal) {
		this.isPrincipal = isPrincipal;
	}

	public int getIdQuestion() {
		return idQuestion;
	}

	public void setIdQuestion(int idQuestion) {
		this.idQuestion = idQuestion;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
