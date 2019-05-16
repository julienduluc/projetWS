package com.springboot.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	    public void saveVoitureOccasion(VoitureOccasion voiture) {
	        this.voitureRepository.saveVoitureOccasion(voiture);
	    }
	    
	    @Override
	    public void saveVoituresOccasion(List<VoitureOccasion> voitures) {
	        this.voitureRepository.saveVoituresOccasion(voitures);
	    }

	    
	    @Override
	    public void deleteVoiture(int voitureId) {
	        this.voitureRepository.deleteVoitureOccasion(voitureId);
	    }

		@Override
		public VoitureOccasion findById(int id) {
			 return this.voitureRepository.findById(id);
		}


		@Override
		public List<VoitureOccasion> findAllVoitures() {
			  return this.voitureRepository.findAll();
		}

}
