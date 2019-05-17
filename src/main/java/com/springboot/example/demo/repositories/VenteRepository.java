package com.springboot.example.demo.repositories;

import com.springboot.example.demo.entities.Vente;
import com.springboot.example.demo.entities.Voiture;

import java.util.ArrayList;
import java.util.List;


public interface VenteRepository {

	List<Vente> findAll();
	Vente findById(int id);
	Vente saveVente(Vente vente);
	void saveVentes(List<Vente> ventes);
	void deleteVente(int id);
}
