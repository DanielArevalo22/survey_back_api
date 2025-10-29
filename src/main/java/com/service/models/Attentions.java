package com.service.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "attentions_clients")
public class Attentions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_attention")
	private int idAttention;
	@Column(name = "identificacion_participant")
	private String identification;
	@Column(name = "service")
	private String service;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "full_name")
	private String fullName;

	public Attentions() {

	}

	public Attentions(int idAttention, String identification, String service, String firstName, String fullName) {
		super();
		this.idAttention = idAttention;
		this.identification = identification;
		this.service = service;
		this.firstName = firstName;
		this.fullName = fullName;
	}

	public int getIdAttention() {
		return idAttention;
	}

	public void setIdAttention(int idAttention) {
		this.idAttention = idAttention;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}