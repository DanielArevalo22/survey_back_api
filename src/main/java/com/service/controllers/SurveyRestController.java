package com.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.service.DTO.AnswerDTO;
import com.service.DTO.ResponseDTO;
import com.service.DTO.SurveyDTO;
import com.service.repository.ISurvey;
import com.service.service.IAnswerImp;

@RestController
@RequestMapping("api/v1/survey")
@CrossOrigin(origins = "http://localhost:4200")
public class SurveyRestController {
	
	@Autowired
	private ISurvey survey;
	@Autowired
	private IAnswerImp answer;
	
	
	@GetMapping("/getSurvey")
	public ResponseDTO sendSurvey(@RequestParam String service) {
		System.out.println("---> " + service);
		ResponseDTO response = null;
		try {
			SurveyDTO surv = survey.getSurvey(service);
			response = new ResponseDTO(200,surv,true); 
			return response;
		} catch (Exception e) {
			response = new ResponseDTO(404,"Survey do not exist",false);
			return response;
		}
	}
	
	@PostMapping("/saveSurvey")
	public ResponseDTO saveSurvey(@RequestBody AnswerDTO a) {
		System.out.println("SURVEY -----> " + a.getSections());
		ResponseDTO response = null;
		try {
			answer.saveSurvey(a);
			response = new ResponseDTO(200,"Saved",true);
		} catch (Exception e) {
			response = new ResponseDTO(400, "Error", false);
		}
		return response;
	}
}
