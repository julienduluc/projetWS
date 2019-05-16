package com.springboot.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.entities.VoitureOccasion;


public interface VoitureService {
	VoitureOccasion getVoitureById(int voitureId);
    void addVoiture(VoitureOccasion voiture);
    void addVoitures(ArrayList<VoitureOccasion> voitures);
    List<VoitureOccasion> getAllVoitures();
    void deleteVoiture(int voitureId);
    void viderListeVoiture();
    
}