package com.springboot.example.demo.services;

import java.util.Collection;
import java.util.List;

import com.springboot.example.demo.entities.Voiture;


public interface VoitureService {
	Voiture findById(Integer id);
    void saveVoiture(Voiture voiture);
    void saveVoitures(List<Voiture> voitures);
    Collection<Voiture> findAllVoitures();
    void deleteVoiture(Integer id);
    Collection<Voiture> rechercheVoitures(String marque, String modele, String prixMin, String prixMax);
    Collection<Voiture> findPhotos();
    Voiture editVoiturePrixQuantite(Integer id, double prix, Integer quantiteRestante);
    void editQuantite(Voiture v, Integer quantiteRestante);
}