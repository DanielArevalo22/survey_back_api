package com.service.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.service.DTO.QuestionsDTO;
import com.service.models.Question;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
@Repository
public class QuestionDAO extends BaseDAO<Question, Integer> {

	@PersistenceContext
	EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	protected QuestionDAO() {
		super(Question.class);
	}

	@Override
	public void persist(Question t) throws PersistenceException {
		super.persist(t);
	}

	@Override
	public void update(Question t) throws PersistenceException {
		super.update(t);
	}

	@Override
	public Optional<Question> find(@NonNull Integer id) {
		return super.find(id);
	}

	
	@Transactional
	public List<QuestionsDTO> getQuestions(int idSection){
		List<QuestionsDTO> questions = new ArrayList<>();
		String sql = "SELECT q.question AS question, q.principal AS principal, q.idQuestion AS idQuestion FROM Question q where q.idSection = :idSection";
		try {
			TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createQuery(sql, Tuple.class);
			query.setParameter("idSection", idSection);
			List<Tuple> lres = query.getResultList();
			for(Tuple t : lres) {
				QuestionsDTO q = new QuestionsDTO();
				q.setQuestion(t.get("question", String.class));
				q.setIsPrincipal(t.get("principal", String.class));
				q.setIdQuestion(t.get("idQuestion", Integer.class));
				questions.add(q);
			}
			return questions;
		} catch (Exception e) {
			System.out.println("ERROR AL OBTENER PREGUNTAS ----> " + e.getMessage());
			return null;
		}
	}
}
