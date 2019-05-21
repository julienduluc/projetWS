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
    Voiture editVoiturePrix(int id, String prix);
}