package com.service.DTO;

public class MailInfoDTO {

	private String template;
	private String subject;

	public MailInfoDTO() {

	}

	public MailInfoDTO(String template, String subject) {
		super();
		this.template = template;
		this.subject = subject;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
