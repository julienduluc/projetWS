package com.springboot.example.demo.entities;

public class VoitureOccasion  {
	
	private int anneeMiseEnCirculation;
	private int id;
	private String marque;
	private double prix;
	private String couleur;

	public int getAnneeMiseEnCirculation() {
		return anneeMiseEnCirculation;
	}

	public void setAnneeMiseEnCirculation(int anneeMiseEnCirculation) {
		this.anneeMiseEnCirculation = anneeMiseEnCirculation;
	}
	
	public int getId() {
		return id;
	}

	public String getMarque() {
		return marque;
	}

	public double getPrix() {
		return prix;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getCouleur() {
		return couleur;
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
}
