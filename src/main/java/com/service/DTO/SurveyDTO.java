package com.service.DTO;

import java.util.List;

public class SurveyDTO {

	private int idSurvey;
	private String survey;
	private List<SectionDTO> sections;
	private String nameParticipant;
	private String idParticipant;

	public SurveyDTO() {

	}

	public SurveyDTO(int idSurvey, String survey, List<SectionDTO> sections, String nameParticipant,
			String idParticipant) {
		super();
		this.idSurvey = idSurvey;
		this.survey = survey;
		this.sections = sections;
		this.nameParticipant = nameParticipant;
		this.idParticipant = idParticipant;
	}

	public int getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
	}

	public String getSurvey() {
		return survey;
	}

	public void setSurvey(String survey) {
		this.survey = survey;
	}

	public List<SectionDTO> getSections() {
		return sections;
	}

	public void setSections(List<SectionDTO> sections) {
		this.sections = sections;
	}

	public String getNameParticipant() {
		return nameParticipant;
	}

	public void setNameParticipant(String nameParticipant) {
		this.nameParticipant = nameParticipant;
	}

	public String getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(String idParticipant) {
		this.idParticipant = idParticipant;
	}

}