package com.springboot.example.demo.entities;

public class Voiture {
	private Integer id;
	private String marque;
	private String modele;
	private double prix;
	private String couleur;
	private Integer anneeSortie;
	private boolean gps;
	private boolean climatisation;
	
	public Integer getId() {
		return id;
	}
	public String getMarque() {
		return marque;
	}
	public String getModele() {
		return modele;
	}
	public double getPrix() {
		return prix;
	}
	public String getCouleur() {
		return couleur;
	}
	public Integer getAnneeSortie() {
		return anneeSortie;
	}
	public boolean isGps() {
		return gps;
	}
	public boolean isClimatisation() {
		return climatisation;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public void setAnneeSortie(Integer anneeSortie) {
		this.anneeSortie = anneeSortie;
	}
	public void setGps(boolean gps) {
		this.gps = gps;
	}
	public void setClimatisation(boolean climatisation) {
		this.climatisation = climatisation;
	}
	
}