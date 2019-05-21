package com.springboot.example.demo.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springboot.example.demo.entities.Vente;


@Repository
public class VenteRepositoryInMemory implements VenteRepository {
	private Map<Integer, Vente> ventes;


	public VenteRepositoryInMemory() {
		this.ventes = new HashMap<>();
	}


	@Override
	public Vente findById(int id) {
		return ventes.get(id);
	}


	@Override
	public Collection<Vente> findAll() {
		return ventes.values();
	}


	@Override
	public Vente saveVente(Vente vente) {
		int i = ventes.size() + 1;
		vente.setId(i);
		this.ventes.put(i, vente);
		return vente;

	}

	@Override
	public void saveVentes(List<Vente> ventes) {
		 for(Vente v : ventes) {
			 this.ventes.put(v.getId(), v);
		 }
	}


	@Override
	public void deleteVente(int id) {
		ventes.remove(id);
	}


	@Override
	public Collection<Vente> getVentesByMarque(String marque) {
		Map<Integer, Vente> liste = new HashMap<>();
		
		ventes.forEach((v, k) -> {			
			if (k.getVoiture().getMarque().equals(marque)) {
				liste.put(k.getId(), k);	
			}			
		});
		return liste.values();
	}


	@Override
	public Collection<Vente> getVentesByAnnee(Integer annee) {
		Map<Integer, Vente> liste = new HashMap<>();
		
		ventes.forEach((v, k) -> {			
			if (k.getAnneeVente() == annee) {
				liste.put(k.getId(), k);	
			}			
		});
		return liste.values();
	}

	@Override
	public double getTotalCAByAnnee(Integer annee) {
		Iterator<Integer> i = ventes.keySet().iterator();
		double total = 0;
		
		while (i.hasNext()) {			
			Integer tmp = i.next();
			if (ventes.get(tmp).getAnneeVente() == annee) {
				total += ventes.get(tmp).getVoiture().getPrix();
			}
		}
		return total;
	}


	@Override
	public Collection<Vente> rechercheVentes(String marque, String annee) {
		Map<Integer, Vente> liste = new HashMap<>();
		
		ventes.forEach((v, k) -> {
			if (k.getAnneeVente() == Integer.parseInt(annee) && (k.getVoiture().getMarque().equals(marque) || marque.equals(""))) {	
				liste.put(k.getId(), k);	
			}
						
		});
		return liste.values();
	}


}
