package com.springboot.example.demo.entities;

import lombok.Data;

@Data
public class Utilisateur {
	private int id;
	private String nom;
	private String prenom;
	private int age;
}
