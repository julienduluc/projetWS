package com.springboot.example.demo.repositories;


import org.springframework.stereotype.Repository;

import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.entities.VoitureOccasion;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoitureRepositoryInMemory implements VoitureRepository {
    private List<VoitureOccasion> voitures;


    public VoitureRepositoryInMemory() {
        this.voitures = new ArrayList<VoitureOccasion>();
    }


	@Override
	public List<VoitureOccasion> findAll() {
		return this.voitures;
	}

	@Override
	public VoitureOccasion findById(int id) {
		for(VoitureOccasion b : this.voitures){
            if(b.getId() == id) return b;
        }

        return null;
	}

	@Override
	public VoitureOccasion saveVoitureOccasion(VoitureOccasion voitureOccasion) {
		this.voitures.add(voitureOccasion);
		return voitureOccasion;
	}

	@Override
	public void saveVoituresOccasion(List<VoitureOccasion> voitureOccasion) {
		 this.voitures = new ArrayList<VoitureOccasion>(voitures);
		
	}

	@Override
	public void deleteVoitureOccasion(int id) {
		for(VoitureOccasion b : this.voitures){
			 
            if(b.getId() == id) {
            	int i = this.voitures.indexOf(b);
            	this.voitures.remove(i);
            }
        }
		
	}

    
}
