package com.service.DTO;

public class AttentionsDTO {

	private String identification;
	private String firstName;

	public AttentionsDTO() {

	}

	public AttentionsDTO(String identification, String firstName) {
		super();
		this.identification = identification;
		this.firstName = firstName;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
