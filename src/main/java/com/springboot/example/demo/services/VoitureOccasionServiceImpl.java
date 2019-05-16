package com.springboot.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.entities.VoitureOccasion;
import com.springboot.example.demo.repositories.VoitureRepository;

@Service
public class VoitureOccasionServiceImpl implements VoitureService {

	 private VoitureRepository voitureRepository;

	    @Autowired
	    public VoitureOccasionServiceImpl(final VoitureRepository voitureRepository){
	        this.voitureRepository = voitureRepository;
	    }

	    @Override
	    public VoitureOccasion getVoitureById(int voitureId) {
	        return this.voitureRepository.getVoitureById(voitureId);
	    }

	    @Override
	    public void addVoiture(VoitureOccasion voiture) {
	        this.voitureRepository.addVoiture(voiture);
	    }
	    
	    @Override
	    public void addVoitures(ArrayList<VoitureOccasion> voitures) {
	        this.voitureRepository.addVoitures(voitures);
	    }

	    @Override
	    public List<VoitureOccasion> getAllVoitures() {
	        return this.voitureRepository.getAllVoitures();
	    }
	    
	    @Override
	    public void deleteVoiture(int voitureId) {
	        this.voitureRepository.deleteVoiture(voitureId);
	    }

		@Override
		public void viderListeVoiture() {
			this.voitureRepository.viderListeVoiture();
			
		}
}
