package com.service.DTO;

import java.util.List;

public class SectionDTO {

	private int idSection;
	private List<QuestionsDTO> questions;

	public SectionDTO() {

	}

	public SectionDTO(int idSection, List<QuestionsDTO> questions) {
		super();
		this.idSection = idSection;
		this.questions = questions;
	}

	public int getIdSection() {
		return idSection;
	}

	public void setIdSection(int idSection) {
		this.idSection = idSection;
	}

	public List<QuestionsDTO> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionsDTO> questions) {
		this.questions = questions;
	}

}
