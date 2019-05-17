package com.springboot.example.demo.services;

import java.util.ArrayList;
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
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void saveVoiture(Voiture voiture) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void saveVoitures(List<Voiture> voitures) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Voiture> findAllVoitures() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void deleteVoiture(Integer id) {
			// TODO Auto-generated method stub
			
		}

	   
}
