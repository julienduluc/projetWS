package com.springboot.example.demo.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.springboot.example.demo.entities.Vente;
import com.springboot.example.demo.repositories.VenteRepository;

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
	public Collection<Vente> findAllVentes() {
		return venteRepository.findAll();
	}

	@Override
	public Vente saveVente(Vente vente) {
		 return venteRepository.saveVente(vente);		
	}

	@Override
	public Collection<Vente> getVentesByMarque(String marque) {
		return venteRepository.getVentesByMarque(marque);
	}

	@Override
	public Collection<Vente> getVentesByAnnee(Integer annee) {
		return venteRepository.getVentesByAnnee(annee);
	}

	@Override
	public double getTotalCAByAnnee(Integer annee) {
		return venteRepository.getTotalCAByAnnee(annee);
	}

	@Override
	public Collection<Vente> rechercheVentes(String marque, String annee) {
		return  venteRepository.rechercheVentes(marque, annee);
	}	
}
