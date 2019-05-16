package com.springboot.example.demo.repositories;

import com.springboot.example.demo.entities.VoitureOccasion;

import java.util.ArrayList;
import java.util.List;

public interface VoitureRepository {
	List<VoitureOccasion> findAll();
	VoitureOccasion findById(int id);
	VoitureOccasion saveVoitureOccasion(VoitureOccasion voitureOccasion);
	void saveVoituresOccasion(List<VoitureOccasion> voitureOccasion);
	void deleteVoitureOccasion(int id);
}
