package com.service.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mail_templates")
public class Templates {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_template")
	private int idTemplate;
	@Column(name = "id_survey")
	private int idSurvey;
	@Column(name = "template")
	private String template;
	@Column(name = "subject")
	private String subject;
	
	public Templates() {
		
	}

	public Templates(int idTemplate, int idSurvey, String template, String subject) {
		super();
		this.idTemplate = idTemplate;
		this.idSurvey = idSurvey;
		this.template = template;
		this.subject = subject;
	}

	public int getIdTemplate() {
		return idTemplate;
	}

	public void setIdTemplate(int idTemplate) {
		this.idTemplate = idTemplate;
	}

	public int getIdSurvey() {
		return idSurvey;
	}

	public void setIdSurvey(int idSurvey) {
		this.idSurvey = idSurvey;
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
