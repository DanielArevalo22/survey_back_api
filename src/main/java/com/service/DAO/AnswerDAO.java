package com.service.DAO;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.service.models.Answer;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Service
@Repository
public class AnswerDAO extends BaseDAO<Answer, Integer> {

	@PersistenceContext
	EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	protected AnswerDAO() {
		super(Answer.class);
	}

	@Override
	public void persist(Answer t) throws PersistenceException {
		super.persist(t);
	}

	@Override
	public void update(Answer t) throws PersistenceException {
		super.update(t);
	}

	@Override
	public Optional<Answer> find(@NonNull Integer id) {
		return super.find(id);
	}

	@Transactional
	public boolean saveAnswers(int idSurvey, String idParticipant, int score, int idQuestion) {
		String sql = "INSERT INTO Answers (id_question, id_survey, id_participant, score) VALUES (:idQuestion,:idSurvey,:idParticipant,:score)";
		try {
			 Query query = em.createNativeQuery(sql);
			 query.setParameter("idQuestion", idQuestion);
			 query.setParameter("idSurvey", idSurvey);
			 query.setParameter("idParticipant", idParticipant);
			 query.setParameter("score", score);
			 query.executeUpdate();
			 return true;
		} catch (Exception e) {
			System.out.println("ERROR SAVING ---> " + e.getMessage());
			return false;
		}
	}
}
