package com.springboot.example.demo.repositories;


import org.springframework.stereotype.Repository;

import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.entities.VoitureOccasion;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoitureRepositoryInMemory implements VoitureRepository {
    private ArrayList<VoitureOccasion> voitures;


    public VoitureRepositoryInMemory() {
        this.voitures = new ArrayList<VoitureOccasion>();
    }

    @Override
    public VoitureOccasion getVoitureById(int bookId) {
        for(VoitureOccasion b : this.voitures){
            if(b.getId() == bookId) return b;
        }

        return null;
    }

    @Override
    public void addVoiture(VoitureOccasion voiture) {
        this.voitures.add(voiture);
    }
    
    @Override
    public void addVoitures(List<VoitureOccasion> voitures) {
        this.voitures = new ArrayList<VoitureOccasion>(voitures);
    }

    @Override
    public List<VoitureOccasion> getAllVoitures() {
        return this.voitures;
    }
    
    @Override
    public void deleteVoiture(int voitureId) {
    	
        for(VoitureOccasion b : this.voitures){
 
            if(b.getId() == voitureId) {
            	int i = this.voitures.indexOf(b);
            	this.voitures.remove(i);
            }
        }
    }

	@Override
	public void viderListeVoiture() {
		this.voitures.clear();
		
	}

    
}
