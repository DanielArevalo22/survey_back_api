package com.service.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.service.DTO.AttentionsDTO;
import com.service.DTO.SectionDTO;
import com.service.DTO.SurveyDTO;
import com.service.models.Survey;
import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
@Repository
public class SurveyDAO extends BaseDAO<Survey, Integer> {

	@PersistenceContext
	EntityManager em;
	@Autowired
	private SectionDAO sections;
	@Autowired
	private AttentionsDAO attention;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	protected SurveyDAO() {
		super(Survey.class);
	}

	@Override
	public void persist(Survey t) throws PersistenceException {
		super.persist(t);
	}

	@Override
	public void update(Survey t) throws PersistenceException {
		super.update(t);
	}

	@Override
	public Optional<Survey> find(@NonNull Integer id) {
		return super.find(id);
	}

	@Transactional
	public SurveyDTO getSurvey(String service) {
		String sql = "SELECT s.survey AS survey, s.idSurvey AS idSurvey FROM Survey s WHERE s.service = :service";
		SurveyDTO survey = new SurveyDTO();
		try {
			TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createQuery(sql, Tuple.class);
			query.setParameter("service", service);
			Tuple t = query.getSingleResult();
			
			/*CALL SECTIONS AND CLIENT DATA*/
			
			List<SectionDTO> getSection = sections.getSections(t.get("idSurvey", Integer.class));
			AttentionsDTO att = attention.getClientAttention(service);
			survey.setSections(getSection);
			survey.setNameParticipant(att.getFirstName());
			survey.setIdParticipant(att.getIdentification());
			survey.setSurvey(t.get("survey", String.class));
			survey.setIdSurvey(t.get("idSurvey", Integer.class));
			return survey;
		} catch (Exception e) {
			System.out.println("Error GETTING SURVEY ----> " + e.getMessage());
			return null;
		}
	}

}
