package com.service.DTO;

public class MailSenderServiceDTO {

	private int idSurvey;
	private String nameParticipant;
	private String mailParticipant;

	public MailSenderServiceDTO() {

	}

	public MailSenderServiceDTO(int idSurvey, String nameParticipant, String mailParticipant) {
		this.idSurvey = idSurvey;
		this.nameParticipant = nameParticipant;
		this.mailParticipant = mailParticipant;
	}

	public int getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
	}

	public String getNameParticipant() {
		return nameParticipant;
	}

	public void setNameParticipant(String nameParticipant) {
		this.nameParticipant = nameParticipant;
	}

	public String getMailParticipant() {
		return mailParticipant;
	}

	public void setMailParticipant(String mailParticipant) {
		this.mailParticipant = mailParticipant;
	}

}
