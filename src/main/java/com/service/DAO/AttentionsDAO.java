package com.service.DAO;

import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.service.DTO.AttentionsDTO;
import com.service.models.Attentions;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Tuple;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Service
@Repository
public class AttentionsDAO extends BaseDAO<Attentions, Integer> {

	@PersistenceContext
	EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	protected AttentionsDAO() {
		super(Attentions.class);
	}

	@Override
	public void persist(Attentions t) throws PersistenceException {
		super.persist(t);
	}

	@Override
	public void update(Attentions t) throws PersistenceException {
		super.update(t);
	}

	@Override
	public Optional<Attentions> find(@NonNull Integer id) {
		return super.find(id);
	}
	
	@Transactional
	public AttentionsDTO getClientAttention(String service) {
		String sql = "SELECT a.firstName AS first_name, a.identification AS idClient FROM Attentions a WHERE a.service = :service";
		try {
			TypedQuery<Tuple> query = (TypedQuery<Tuple>) em.createQuery(sql, Tuple.class);
			query.setParameter("service", service);
			Tuple t = query.getSingleResult();
			AttentionsDTO att = new AttentionsDTO();
			att.setFirstName(t.get("first_name", String.class));
			att.setIdentification(t.get("idClient", String.class));
			return att;
		} catch (Exception e) {
			System.out.println("ERROR GETTING ATTENTION---> " + e.getMessage());
			return null;
		}
	}
}
