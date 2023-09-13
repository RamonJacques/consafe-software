package com.consafe.application.dao.impl;

import java.util.List;

import com.consafe.application.dao.SteelBarDao;
import com.consafe.application.entities.SteelBar;

import jakarta.persistence.EntityManager;

public class SteelBarDaoJPA implements SteelBarDao{

	@Override
	public void insert(SteelBar obj) {
		EntityManager em = JpaUtils.getEntityManager();
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public void update(SteelBar obj) {
		EntityManager em = JpaUtils.getEntityManager();
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em = JpaUtils.getEntityManager();
		em.getTransaction().begin();
		SteelBar obj = em.find(SteelBar.class, id);
		em.remove(obj);
		em.getTransaction().commit();
		em.close();		
	}

	@Override
	public SteelBar findById(Integer id) {
		EntityManager em = JpaUtils.getEntityManager();
		SteelBar obj = em.find(SteelBar.class, id);
		em.close();
		return obj;
	}

	@Override
	public List<SteelBar> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		List<SteelBar> list = em.createQuery("from MateriaPrima", SteelBar.class).getResultList();			
		em.close();			
		return list;
	}

}
