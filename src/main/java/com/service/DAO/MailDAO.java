package com.service.DAO;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.service.DTO.MailInfoDTO;
import com.service.models.Templates;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
@Repository
public class MailDAO extends BaseDAO<Templates, Integer>{

	@PersistenceContext
	EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	protected MailDAO() {
		super(Templates.class);
	}

	@Override
	public void persist(Templates t) throws PersistenceException {
		super.persist(t);
	}

	@Override
	public void update(Templates t) throws PersistenceException {
		super.update(t);
	}

	@Override
	public Optional<Templates> find(@NonNull Integer id) {
		return super.find(id);
	}
	
	@Transactional
	public MailInfoDTO getTemplate(int idSurvey) {
		String sql = "SELECT t.template AS template, t.subject AS subject FROM Templates t WHERE t.idSurvey = :idSurvey";
		MailInfoDTO mailBody = new MailInfoDTO();
		try {
			TypedQuery<Tuple> query = em.createQuery(sql, Tuple.class);
			query.setParameter("idSurvey", idSurvey);
			Tuple t = query.getSingleResult();
			mailBody.setSubject(t.get("subject", String.class));
			mailBody.setTemplate(t.get("template", String.class));
			return mailBody;
		} catch (Exception e) {
			System.out.println("ERROR ---------> " + e.getMessage());
			return null;
		}
	}
	
}
