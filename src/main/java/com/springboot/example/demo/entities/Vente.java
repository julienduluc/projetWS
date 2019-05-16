package com.springboot.example.demo.entities;

import lombok.Data;

@Data
public class Vente {
	private int id;
	private int anneeVente;
	private Utilisateur utilisateur;
	private VoitureOccasion voiture;
}
