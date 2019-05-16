package com.springboot.example.demo.entities;


public abstract class Voiture {

	private int id;
	private String marque;
	private double prix;

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
}
