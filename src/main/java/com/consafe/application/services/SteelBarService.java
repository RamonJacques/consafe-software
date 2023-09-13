package com.consafe.application.services;

import java.util.List;

import com.consafe.application.dao.DaoFactory;
import com.consafe.application.dao.SteelBarDao;
import com.consafe.application.entities.SteelBar;

public class SteelBarService {

	private SteelBarDao dao = DaoFactory.createSteelBarDao();
	
	public List<SteelBar> findAll() {
		return dao.findAll();
	}
	
	public void saveOrUpdate(SteelBar obj) {
		if (obj.getId() == null) {
			dao.insert(obj);
		}
		else {
			dao.update(obj);
		}
	}
	
	public void remove(SteelBar obj) {
		dao.deleteById(obj.getId());
	}
}
