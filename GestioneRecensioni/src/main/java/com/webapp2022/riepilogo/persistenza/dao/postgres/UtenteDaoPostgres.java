package com.webapp2022.riepilogo.persistenza.dao.postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.webapp2022.riepilogo.model.Utente;
import com.webapp2022.riepilogo.persistenza.dao.UtenteDao;

public class UtenteDaoPostgres implements UtenteDao{
	Connection conn;
	
	public UtenteDaoPostgres(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public List<Utente> findAll() {
		List<Utente> utenti = new ArrayList<Utente>();
		String query = "select * from riepilogo.utenti";
		try {
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				Utente utente = new Utente();
				utente.setUsername(rs.getString("username"));
				utente.setPassword(rs.getString("password"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));

				utenti.add(utente);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utenti;
	}

	@Override
	public Utente findByPrimaryKey(String username) {
		Utente utente = null;
		String query = "select * from riepilogo.utenti where username = ?";
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			
			if (rs.next()) {
				utente = new Utente();
				utente.setUsername(rs.getString("username"));
				utente.setPassword(rs.getString("password"));
				utente.setNome(rs.getString("nome"));
				utente.setCognome(rs.getString("cognome"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return utente;
	}

	@Override
	public void saveOrUpdate(Utente utente) {
		//Check existance of user
		if (findByPrimaryKey(utente.getUsername()) == null) {
			String insertStr = "INSERT INTO riepilogo.utenti VALUES (?, ?, ?, ?)";
			
			PreparedStatement st;
			try {
				st = conn.prepareStatement(insertStr);
				st.setString(1, utente.getUsername());
				st.setString(2, utente.getPassword());
				st.setString(3, utente.getNome());
				st.setString(4, utente.getCognome());
				
				
				st.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			String updateStr = "UPDATE riepilogo.utenti set password = ?, "
												+ "nome = ?, "
												+ "cognome = ? "
												+ "where username = ?";
			
			PreparedStatement st;
			try {
				st = conn.prepareStatement(updateStr);
			
				st.setString(1, utente.getPassword());
				st.setString(2, utente.getNome());
				st.setString(3, utente.getCognome());
				
				st.setString(4, utente.getUsername());
				
				st.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void delete(Utente utente) {
		String query = "DELETE FROM riepilogo.utenti WHERE username = ?";		
		try {
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, utente.getUsername());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
