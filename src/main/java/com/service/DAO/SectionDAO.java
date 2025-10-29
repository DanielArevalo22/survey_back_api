package com.service.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.service.DTO.QuestionsDTO;
import com.service.DTO.SectionDTO;
import com.service.models.Section;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
@Repository
public class SectionDAO extends BaseDAO<Section, Integer>{

	@PersistenceContext
	EntityManager em;
	@Autowired
	private QuestionDAO questions;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	protected SectionDAO() {
		super(Section.class);
	}

	@Override
	public void persist(Section t) throws PersistenceException {
		super.persist(t);
	}

	@Override
	public void update(Section t) throws PersistenceException {
		super.update(t);
	}

	@Override
	public Optional<Section> find(@NonNull Integer id) {
		return super.find(id);
	}
	
	@Transactional
	public List<SectionDTO> getSections(int idSurvey){
		List<SectionDTO> sections = new ArrayList<>();
		String sql = "SELECT s.section AS section, s.idSection AS idSection FROM Section s WHERE s.idSurvey = :idSurvey";
		try {
			TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createQuery(sql, Tuple.class);
			query.setParameter("idSurvey", idSurvey);
			List<Tuple> lres = query.getResultList();
			for(Tuple s : lres) {
				SectionDTO section = new SectionDTO();
				int idSection = s.get("idSection", Integer.class);
				List<QuestionsDTO> questionsList = questions.getQuestions( idSection);
				section.setQuestions(questionsList);
				section.setIdSection(idSection);
				sections.add(section);
			}
			return sections;
		} catch (Exception e) {
			System.out.println("ERROR GETTING SECTIONS -----> " + e.getMessage());
			return null;
		}
	}
}
