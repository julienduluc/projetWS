package com.springboot.example.demo.repositories;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springboot.example.demo.entities.Voiture;

@Repository
public class VoitureRepositoryInMemory implements VoitureRepository {
    private Map<Integer, Voiture> voitures;


    public VoitureRepositoryInMemory() {
        this.voitures = new HashMap<>();
    }


	@Override
	public Collection<Voiture> findAll() {
		return this.voitures.values();
	}

	@Override
	public Voiture findById(int id) {
        return voitures.get(id);
	}

	@Override
	public Voiture saveVoiture(Voiture voiture) {
		int i = voitures.size() + 1;
		voiture.setId(i);
		this.voitures.put(i, voiture);
		return voiture;
	}

	@Override
	public void saveVoitures(List<Voiture> voitures) {		 
		 for(Voiture v : voitures) {
			 this.voitures.put(v.getId(), v);
		 }		
	}

	@Override
	public void deleteVoiture(int id) {
		voitures.remove(id);		
	}    
}
