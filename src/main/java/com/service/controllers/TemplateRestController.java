package com.service.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.DTO.MailSenderServiceDTO;
import com.service.DTO.ResponseDTO;
import com.service.service.ITemplateImp;

@RestController
@RequestMapping("/api/v1/mail_sender")
public class TemplateRestController {
	
	@Autowired
	private ITemplateImp template;
	
	@PostMapping("/send_mail")
	public ResponseDTO sendMail(@RequestBody MailSenderServiceDTO a){
		ResponseDTO response = null;
		try {
			boolean x = template.getTemplateSurvey(a.getIdSurvey(), a.getNameParticipant(), a.getMailParticipant());
			System.out.println("---> " + x);
			response = new ResponseDTO(200,"MAIL SEND", true);
		} catch (Exception e) {
			response = new ResponseDTO(500,"ERROR SENDING MAIL", false);
		}
		return response;
	}
}
