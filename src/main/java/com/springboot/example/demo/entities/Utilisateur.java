package com.springboot.example.demo.entities;


public class Utilisateur {

	private int id;
	private String nom;
	private double prenom;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(double prenom) {
		this.prenom = prenom;
	}


	public void setAge(int age) {
		this.age = age;
	}

	public String getNom() {
		return nom;
	}

	public double getPrenom() {
		return prenom;
	}

	public int getAge() {
		return age;
	}

}
