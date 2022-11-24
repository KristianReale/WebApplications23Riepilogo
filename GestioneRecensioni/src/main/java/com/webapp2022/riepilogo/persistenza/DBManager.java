package com.webapp2022.riepilogo.persistenza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.webapp2022.riepilogo.persistenza.dao.RecensioneDao;
import com.webapp2022.riepilogo.persistenza.dao.UtenteDao;

import it.unical.mat.webapp23.catena_ristoranti.persistenza.dao.postgres.RecensioneDaoPostgres;
import it.unical.mat.webapp23.catena_ristoranti.persistenza.dao.postgres.UtenteDaoPostgres;

public class DBManager {
	private static DBManager instance = null;
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
	}
	
	Connection conn = null;
	
	public Connection getConnection() {
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "postgres");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public UtenteDao getUtenteDao() {
		return new UtenteDaoPostgres(getConnection());
	}
	
	
	public RecensioneDao getRecensioneDao() {
		return new RecensioneDaoPostgres(getConnection());
	}
}
