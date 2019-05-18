package com.springboot.example.demo.repositories;

import java.util.List;

import com.springboot.example.demo.entities.Vente;


public interface VenteRepository {

	List<Vente> findAll();
	Vente findById(int id);
	Vente saveVente(Vente vente);
	void saveVentes(List<Vente> ventes);
	void deleteVente(int id);
}
