package com.consafe.application.dao;

import com.consafe.application.dao.impl.SteelBarDaoJPA;

public class DaoFactory {

	public static SteelBarDao createSteelBarDao() {
		return new SteelBarDaoJPA();
	}	
}
