package com.consafe.application.dao;

import java.util.List;

import com.consafe.application.entities.SteelBar;

public interface SteelBarDao {

	void insert(SteelBar obj);
	void update(SteelBar obj);
	void deleteById(Integer id);
	SteelBar findById(Integer id);
	List<SteelBar> findAll();
}
