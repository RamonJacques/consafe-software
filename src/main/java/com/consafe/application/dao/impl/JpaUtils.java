package com.consafe.application.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtils {
	private static EntityManagerFactory entityManagerFactory = null;
	
	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("csf-jpa");
		}
		return entityManagerFactory.createEntityManager();
	}
}
