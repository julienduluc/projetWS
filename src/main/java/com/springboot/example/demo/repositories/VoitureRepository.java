package com.springboot.example.demo.repositories;

import java.util.Collection;
import java.util.List;

import com.springboot.example.demo.entities.Voiture;

public interface VoitureRepository {
	Collection<Voiture> findAll();
	Voiture findById(int id);
	Voiture saveVoiture(Voiture voiture);
	void saveVoitures(List<Voiture> voiture);
	void deleteVoiture(int id);
	Collection<Voiture> rechercheVoitures(String marque, String modele, String prixMin, String prixMax);
	void encodePhotoVoiture(Voiture v);
	Collection<Voiture> findPhotos();
	Voiture editVoiturePrixQuantite(Integer id, double prix, Integer quantiteRestante);
	void editQuantite(Voiture v, Integer quantiteRestante);
}
