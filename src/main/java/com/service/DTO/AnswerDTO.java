package com.service.DTO;

import java.util.List;

public class AnswerDTO {

	private String idParticipant;
	private int idSurvey;
	private List<SectionDTO> sections;

	public AnswerDTO() {

	}

	public AnswerDTO(String idParticipant, int idSurvey, List<SectionDTO> sections) {
		super();
		this.idParticipant = idParticipant;
		this.idSurvey = idSurvey;
		this.sections = sections;
	}

	public String getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(String idParticipant) {
		this.idParticipant = idParticipant;
	}

	public int getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
	}

	public List<SectionDTO> getSections() {
		return sections;
	}

	public void setSections(List<SectionDTO> sections) {
		this.sections = sections;
	}

}
