package com.springboot.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.entities.VoitureOccasion;


public interface VoitureService {
	VoitureOccasion findById(int id);
    void saveVoitureOccasion(VoitureOccasion voiture);
    void saveVoituresOccasion(List<VoitureOccasion> voitures);
    List<VoitureOccasion> findAllVoitures();
    void deleteVoiture(int id);
    
}