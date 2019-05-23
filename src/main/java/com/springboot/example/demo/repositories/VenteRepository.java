package com.springboot.example.demo.repositories;

import java.util.Collection;
import java.util.List;

import com.springboot.example.demo.entities.Vente;
import com.springboot.example.demo.entities.Voiture;


public interface VenteRepository {

	Collection<Vente> findAll();
	Vente findById(int id);
	Vente saveVente(Vente vente);
	void saveVentes(List<Vente> ventes);
	void deleteVente(int id);
	Collection<Vente> getVentesByMarque(String marque);
	Collection<Vente> getVentesByAnnee(Integer annee);
	double getTotalCAByAnnee(Integer annee);
	Collection<Vente> rechercheVentes(String marque, String annee);
	void decrementeQuantiteRestante(Voiture voiture);
}
