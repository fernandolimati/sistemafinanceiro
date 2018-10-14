package com.fatesg.sistemafinanceiro.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.fatesg.sistemafinanceiro.entity.EntityGetId;
import com.fatesg.sistemafinanceiro.util.GetConnectionEMF;

public class GenericDao<T extends EntityGetId> {

	public T save(T t) throws Exception{
		EntityManager em = GetConnectionEMF.getEntityManager();
		try {
			em.getTransaction().begin();
			if(t.getId() == null) {
				em.persist(t);
			}else {
				if(!em.contains(t)) {
					if(em.find(t.getClass(), t.getId()) == null) {
						throw new Exception("Erro ao atualizar!");
					}
				}
				t = em.merge(t);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return t;
	}

	public T delete(Class<T> c, Long id) {
		EntityManager em = GetConnectionEMF.getEntityManager();
		T t = em.find(c, id);
		try {
			em.getTransaction().begin();
			em.remove(t);
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return t;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> listAll(Class<T> c){
		EntityManager em = GetConnectionEMF.getEntityManager();
		em.getTransaction().begin();
		
		List<T> list = em.createQuery("SELECT c from "+ c.getName()+" c").getResultList();
		
		em.getTransaction().commit();
		em.close();
		
		return list;
	}

	public T findById(Class<T> c, Long id) {
		EntityManager em = GetConnectionEMF.getEntityManager();
		T t = null;
		try {
			t = em.find(c, id);
		} finally {
			em.close();
		}
		return t;
	}
}
