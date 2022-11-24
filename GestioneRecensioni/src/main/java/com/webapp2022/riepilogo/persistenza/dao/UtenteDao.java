package com.webapp2022.riepilogo.persistenza.dao;

import java.util.List;

import com.webapp2022.riepilogo.model.Utente;

public interface UtenteDao {
	public List<Utente> findAll();
	
	public Utente findByPrimaryKey(String username);
	
	public void saveOrUpdate(Utente utente);
	
	public void delete(Utente utente);
}
