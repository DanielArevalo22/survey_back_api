package com.service.repository;

import org.springframework.stereotype.Repository;

import com.service.DTO.SurveyDTO;

@Repository
public interface ISurvey{

	public SurveyDTO getSurvey(String service);
}
