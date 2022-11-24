package com.webapp2022.riepilogo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.webapp2022.riepilogo.model.Utente;
import com.webapp2022.riepilogo.persistenza.DBManager;

@SpringBootTest
class GestioneRecensioniApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	public void testUtenti() {
		List<Utente> utenti = DBManager.getInstance().getUtenteDao().findAll();
		for (Utente utente : utenti) {
			assertNotNull(utente.getUsername());
			System.out.println(utente.getUsername());
		}
		
	}
}
