package com.springboot.example.demo.repositories;

import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.entities.VoitureOccasion;

import java.util.ArrayList;
import java.util.List;

public interface VoitureRepository {
	VoitureOccasion getVoitureById(int voitureId);
    void addVoiture(VoitureOccasion voiture);
    void addVoitures(List<VoitureOccasion> voitures);
    List<VoitureOccasion> getAllVoitures();
    void deleteVoiture(int voitureId);
    void viderListeVoiture();
}
