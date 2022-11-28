package com.webapp2022.riepilogo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webapp2022.riepilogo.model.Recensione;
import com.webapp2022.riepilogo.persistenza.DBManager;
import com.webapp2022.riepilogo.persistenza.dao.RecensioneDao;

@WebServlet("/miPiaceAction")
public class MiPiaceServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String recensioneId = req.getParameter("recensione");
		
		RecensioneDao recDao = DBManager.getInstance().getRecensioneDao();
		Recensione rec = recDao.findByPrimaryKey(Long.parseLong(recensioneId));
		
		rec.setNumeroMiPiace(rec.getNumeroMiPiace() + 1);
		
		recDao.saveOrUpdate(rec);
		
		resp.getWriter().print(rec.getNumeroMiPiace());
//		resp.setStatus(500);
		
	}
	
	
	
	
	
	
	
}
