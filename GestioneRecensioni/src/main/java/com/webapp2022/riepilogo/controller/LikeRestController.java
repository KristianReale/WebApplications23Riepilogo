package com.webapp2022.riepilogo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp2022.riepilogo.model.Recensione;
import com.webapp2022.riepilogo.persistenza.DBManager;
import com.webapp2022.riepilogo.persistenza.dao.RecensioneDao;

@RestController
public class LikeRestController {
	@PostMapping("/miPiaceAction")
	public Integer miPiace(@RequestParam Long recensione) {
//		String recensioneId = req.getParameter("recensione");

		RecensioneDao recDao = DBManager.getInstance().getRecensioneDao();
//		Recensione rec = recDao.findByPrimaryKey(Long.parseLong(recensione));
		Recensione rec = recDao.findByPrimaryKey(recensione);

		rec.setNumeroMiPiace(rec.getNumeroMiPiace() + 1);

		recDao.saveOrUpdate(rec);

		return rec.getNumeroMiPiace();
//		resp.getWriter().print(rec.getNumeroMiPiace());
	}

}
