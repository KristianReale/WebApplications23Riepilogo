package com.webapp2022.riepilogo.model;

public class Recensione {
	Long id;
	String titolo;
	String testo;
	Integer numeroMiPiace;
	Integer numeroNonMiPiace;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public Integer getNumeroMiPiace() {
		return numeroMiPiace;
	}
	public void setNumeroMiPiace(Integer numeroMiPiace) {
		this.numeroMiPiace = numeroMiPiace;
	}
	public Integer getNumeroNonMiPiace() {
		return numeroNonMiPiace;
	}
	public void setNumeroNonMiPiace(Integer numeroNonMiPiace) {
		this.numeroNonMiPiace = numeroNonMiPiace;
	}
	
	
}
