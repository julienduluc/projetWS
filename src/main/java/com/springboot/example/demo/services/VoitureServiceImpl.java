package com.springboot.example.demo.services;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.repositories.VoitureRepository;

@Service
public class VoitureServiceImpl implements VoitureService {

	private VoitureRepository voitureRepository;

	    @Autowired
	    public VoitureServiceImpl(final VoitureRepository voitureRepository){
	        this.voitureRepository = voitureRepository;
	    }

		@Override
		public Voiture findById(Integer id) {
			return voitureRepository.findById(id);
		}

		@Override
		public void saveVoiture(Voiture voiture) {
			this.voitureRepository.saveVoiture(voiture);			
		}

		@Override
		public void saveVoitures(List<Voiture> voitures) {
			this.voitureRepository.saveVoitures(voitures);			
		}

		@Override
		public Collection<Voiture> findAllVoitures() {
			return voitureRepository.findAll();
		}

		@Override
		public void deleteVoiture(Integer id) {
			voitureRepository.deleteVoiture(id);			
		}

		@Override
		public Collection<Voiture> rechercheVoitures(String marque, String modele, String prixMin, String prixMax) {
			return voitureRepository.rechercheVoitures(marque, modele, prixMin, prixMax);
		}


		@Override
		public Collection<Voiture> findPhotos() {
			return voitureRepository.findPhotos();
		}

		public Voiture editVoiturePrixQuantite(Integer id, double prix, Integer quantiteRestante) {
			return voitureRepository.editVoiturePrixQuantite(id, prix,quantiteRestante);
			
		}	   
		
}
