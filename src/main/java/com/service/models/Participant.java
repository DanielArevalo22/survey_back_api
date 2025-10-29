package com.service.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "participants")
public class Participant {

	@Id
	@Column(name = "id_participant")
	private int id;
	@Column(name = "identification")
	private String identification;
	@Column(name = "full_name")
	private String fullName;
	@Column(name = "answered_at")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date answeredAt;

	public Participant() {

	}

	public Participant(int id, String identification, String fullName, Date answeredAt) {
		this.id = id;
		this.identification = identification;
		this.fullName = fullName;
		this.answeredAt = answeredAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getAnsweredAt() {
		return answeredAt;
	}

	public void setAnsweredAt(Date answeredAt) {
		this.answeredAt = answeredAt;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

}
