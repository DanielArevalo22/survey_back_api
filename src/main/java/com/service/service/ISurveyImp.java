package com.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.DAO.SurveyDAO;
import com.service.DTO.SurveyDTO;
import com.service.repository.ISurvey;

@Service
public class ISurveyImp implements ISurvey{
	
	@Autowired
	private SurveyDAO survey;

	@Override
	public SurveyDTO getSurvey(String service) {
		try {
			return survey.getSurvey(service);
		} catch (Exception e) {
			return null;
		}
	}
	
}
