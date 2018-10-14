package com.fatesg.sistemafinanceiro.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetConnectionEMF {
	private static EntityManagerFactory factory = null;
	
	static {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("sistemafinanceiro");
		}
	}
	
	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}
}
