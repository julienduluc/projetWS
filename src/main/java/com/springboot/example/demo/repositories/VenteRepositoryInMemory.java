package com.springboot.example.demo.repositories;

import org.springframework.stereotype.Repository;
import com.springboot.example.demo.entities.Vente;
import com.springboot.example.demo.entities.VoitureOccasion;

import java.util.ArrayList;
import java.util.List;


@Repository
public class VenteRepositoryInMemory implements VenteRepository {
	private List<Vente> ventes;


	public VenteRepositoryInMemory() {
		this.ventes = new ArrayList<Vente>();
	}


	@Override
	public Vente findById(int id) {

		for(Vente b : this.ventes){
			if(b.getId() == id) return b;
		}

		return null;
	}


	@Override
	public List<Vente> findAll() {
		return ventes;
	}


	@Override
	public Vente saveVente(Vente vente) {
		this.ventes.add(vente);
		return vente;

	}

	@Override
	public void saveVentes(List<Vente> ventes) {
		this.ventes = ventes;

	}


	@Override
	public void deleteVente(int id) {
		for(Vente b : this.ventes){

			if(b.getId() == id) {
				int i = this.ventes.indexOf(b);
				this.ventes.remove(i);
			}
		}

	}



}
