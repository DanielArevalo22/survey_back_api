package com.service.DAO;

import java.util.Optional;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;

public abstract class BaseDAO<T,K> {
	
	private final Class<T> clazz;

	protected BaseDAO(Class<T> clazz) {
	this.clazz = clazz;
	}

	protected abstract EntityManager getEntityManager();

	public void persist(T t) throws PersistenceException {
	EntityManager em = getEntityManager();
	em.persist(t);
	}

	public void update(T t) throws PersistenceException {
	EntityManager em = getEntityManager();
	em.merge(t);
	}

	public void remove(T t) throws PersistenceException {
	EntityManager em = getEntityManager();
	em.remove(t);
	em.getTransaction().commit();
	}

	public Optional<T> find(@NonNull K id) {
	EntityManager em = getEntityManager();
	T t = em.find(clazz, id);
	return Optional.ofNullable(t);
	}

	public Optional<T> find(@NonNull int id) {
	EntityManager em = getEntityManager();
	T t = em.find(clazz, id);
	return Optional.ofNullable(t);
	}

}
