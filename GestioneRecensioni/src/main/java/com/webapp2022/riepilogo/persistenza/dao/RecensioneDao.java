package com.webapp2022.riepilogo.persistenza.dao;

import java.util.List;

import com.webapp2022.riepilogo.model.Recensione;

public interface RecensioneDao {
	public List<Recensione> findAll();
	
	public Recensione findByPrimaryKey(Long id);
	
	public void saveOrUpdate(Recensione recensione);
	
	public void delete(Recensione recensione);
}
