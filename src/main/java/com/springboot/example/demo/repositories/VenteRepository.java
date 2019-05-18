package com.springboot.example.demo.repositories;

import java.util.Collection;
import java.util.List;

import com.springboot.example.demo.entities.Vente;


public interface VenteRepository {

	Collection<Vente> findAll();
	Vente findById(int id);
	Vente saveVente(Vente vente);
	void saveVentes(List<Vente> ventes);
	void deleteVente(int id);
	Collection<Vente> getVentesByMarque(String marque);
	Collection<Vente> getVentesByAnnee(Integer annee);
}
