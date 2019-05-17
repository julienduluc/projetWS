package com.springboot.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.springboot.example.demo.entities.Voiture;


public interface VoitureService {
	Voiture findById(Integer id);
    void saveVoiture(Voiture voiture);
    void saveVoitures(List<Voiture> voitures);
    List<Voiture> findAllVoitures();
    void deleteVoiture(Integer id);
    
}