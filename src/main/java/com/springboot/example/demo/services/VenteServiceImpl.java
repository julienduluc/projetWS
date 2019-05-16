package com.springboot.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.example.demo.entities.Vente;
import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.repositories.VenteRepository;
import com.springboot.example.demo.repositories.VoitureRepository;

@Service
public class VenteServiceImpl implements VenteService {

	private VenteRepository venteRepository;

	public VenteServiceImpl(VenteRepository venteRepository) { 
		this.venteRepository = venteRepository;
	}

	@Override
	public Vente getVenteById(int id) {
		return venteRepository.findById(id);
	}

	@Override
	public List<Vente> findAllVentes() {
		return venteRepository.findAll();
	}

	@Override
	public Vente saveVente(Vente vente) {
		 return venteRepository.saveVente(vente);		
	}	
}
