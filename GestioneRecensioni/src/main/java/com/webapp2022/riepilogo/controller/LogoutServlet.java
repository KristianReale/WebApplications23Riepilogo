package com.webapp2022.riepilogo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp2022.riepilogo.model.Utente;
import com.webapp2022.riepilogo.persistenza.DBManager;
import com.webapp2022.riepilogo.persistenza.dao.UtenteDao;

@WebServlet("/doLogout")
public class LogoutServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("user");
		session.invalidate();

		resp.sendRedirect("/");

		
	}
}
