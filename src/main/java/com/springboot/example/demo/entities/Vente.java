package com.springboot.example.demo.entities;


public class Vente {
	private int id;
	private int anneeVente;
	private Utilisateur utilisateur;
	private Voiture voiture;
	
	
	public int getId() {
		return id;
	}
	public int getAnneeVente() {
		return anneeVente;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public Voiture getVoiture() {
		return voiture;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setAnneeVente(int anneeVente) {
		this.anneeVente = anneeVente;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}
}
