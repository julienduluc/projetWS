package com.springboot.example.demo.repositories;


import org.springframework.stereotype.Repository;

import com.springboot.example.demo.entities.Voiture;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoitureRepositoryInMemory implements VoitureRepository {
    private List<Voiture> voitures;


    public VoitureRepositoryInMemory() {
        this.voitures = new ArrayList<Voiture>();
    }


	@Override
	public List<Voiture> findAll() {
		return this.voitures;
	}

	@Override
	public Voiture findById(int id) {
		for(Voiture b : this.voitures){
            if(b.getId() == id) return b;
        }

        return null;
	}

	@Override
	public Voiture saveVoiture(Voiture voiture) {
		this.voitures.add(voiture);
		return voiture;
	}

	@Override
	public void saveVoitures(List<Voiture> voiture) {
		 this.voitures = new ArrayList<Voiture>(voitures);
		
	}

	@Override
	public void deleteVoiture(int id) {
		for(Voiture b : this.voitures){
			 
            if(b.getId() == id) {
            	int i = this.voitures.indexOf(b);
            	this.voitures.remove(i);
            }
        }
		
	}

    
}
