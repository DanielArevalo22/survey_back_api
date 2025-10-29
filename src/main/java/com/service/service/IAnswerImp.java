package com.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.DAO.AnswerDAO;
import com.service.DTO.AnswerDTO;
import com.service.DTO.QuestionsDTO;
import com.service.DTO.SectionDTO;

import jakarta.transaction.Transactional;

@Service
public class IAnswerImp {
	
	@Autowired
	private AnswerDAO answerObj;
	
	
	@Transactional
	public String saveSurvey(AnswerDTO a) {
		int idSurvey = a.getIdSurvey();
		String idParticipant = a.getIdParticipant();
		List<SectionDTO> sections = a.getSections();
		try {
			
			/* LOOK INSIDE SECTIONS  */
			for(SectionDTO section : sections ) {
				
				/* TAKE THE DATA FROM THE QUESTIONS */
				for(QuestionsDTO question : section.getQuestions()) {
					
					int idQuestion = question.getIdQuestion();
					int score = question.getScore();
					answerObj.saveAnswers(idSurvey, idParticipant, score, idQuestion);
				}
				
			}
			
			return "SURVEY SAVED";
			
		} catch (Exception e) {
			System.out.println("ERROR PERSIT SURVEY ---> " + e.getMessage());
			return "ERROR SAVING";
		}
	}

}
