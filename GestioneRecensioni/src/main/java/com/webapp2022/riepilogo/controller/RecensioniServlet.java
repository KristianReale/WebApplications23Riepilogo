package com.webapp2022.riepilogo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp2022.riepilogo.model.Recensione;
import com.webapp2022.riepilogo.persistenza.DBManager;

@WebServlet("/recensioni")
public class RecensioniServlet extends HomeServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String view;
		if (session.getAttribute("user") != null) {
			List<Recensione> recensioni = DBManager.getInstance().getRecensioneDao().findAll();
			req.setAttribute("recensioni", recensioni);
			
			view = "recensioni.html";
		}else {
			view = "nonSeiAutorizzato.html";
		}
		
		RequestDispatcher dispacher = req.getRequestDispatcher("views/" + view);
		dispacher.forward(req, resp);
	}
}
