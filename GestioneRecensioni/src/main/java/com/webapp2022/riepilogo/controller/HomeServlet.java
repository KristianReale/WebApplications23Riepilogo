package com.webapp2022.riepilogo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webapp2022.riepilogo.model.Utente;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Utente u = (Utente)session.getAttribute("user");
		System.out.println("hh" + u);
		if (u != null) {
			req.setAttribute("user", u);
		}
		
		RequestDispatcher dispacher = req.getRequestDispatcher("views/index.html");
		dispacher.forward(req, resp);
	}
}
