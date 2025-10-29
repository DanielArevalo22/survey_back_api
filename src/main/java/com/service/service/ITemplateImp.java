package com.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.service.DAO.MailDAO;
import com.service.DTO.MailInfoDTO;

import jakarta.mail.internet.MimeMessage;

@Service
public class ITemplateImp {
	
	@Autowired
	private MailDAO mail;
	
	@Autowired
	private JavaMailSender mailSender;
	
	public boolean getTemplateSurvey(int idSurvey, String nameParticipant, String mailParticipant) {
		MimeMessage mensaje = mailSender.createMimeMessage();
		try {
			
			MailInfoDTO infoMail = mail.getTemplate(idSurvey);
			String template = infoMail.getTemplate();
			template = template.replace("@clientName@", nameParticipant);
				
				MimeMessageHelper helper = new MimeMessageHelper(mensaje, true);
				helper.setTo(mailParticipant);
				helper.setSubject(infoMail.getSubject());
				helper.setText(template, true);
				mailSender.send(mensaje);
			return true;
			
		} catch (Exception e) {
			System.out.println("----> " + e.getMessage());
			return false;
		}
	}
}
