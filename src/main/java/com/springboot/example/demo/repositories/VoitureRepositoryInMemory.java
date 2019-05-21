package com.springboot.example.demo.repositories;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.springboot.example.demo.entities.Vente;
import com.springboot.example.demo.entities.Voiture;

@Repository
public class VoitureRepositoryInMemory implements VoitureRepository {
    private Map<Integer, Voiture> voitures;


    public VoitureRepositoryInMemory() {
        this.voitures = new HashMap<>();
    }


	@Override
	public Collection<Voiture> findAll() {
		return this.voitures.values();
	}

	@Override
	public Voiture findById(int id) {
        return voitures.get(id);
	}

	@Override
	public Voiture saveVoiture(Voiture voiture) {
		int i = voitures.size() + 1;
		voiture.setId(i);
		this.voitures.put(i, voiture);
		return voiture;
	}

	@Override
	public void saveVoitures(List<Voiture> voitures) {		 
		 for(Voiture v : voitures) {
			 this.voitures.put(v.getId(), v);
		 }		
	}

	@Override
	public void deleteVoiture(int id) {
		voitures.remove(id);		
	}
	
	@Override
	public Collection<Voiture> rechercheVoitures(String marque, String modele, String prixMin, String prixMax) {
		Map<Integer, Voiture> liste = new HashMap<>();
		
		voitures.forEach((v, k) -> {
			if ((k.getMarque().equals(marque) || marque.equals("")) && (k.getModele().equals(modele) || modele.equals("")) && 
					k.getPrix() >= Integer.parseInt(prixMin) && k.getPrix() <= Integer.parseInt(prixMax)) {	
				liste.put(k.getId(), k);	
			}
						
		});
		return liste.values();
	}


	@Override
	public Voiture editVoiturePrix(Integer id, String prix) {
		Voiture v = findById(id);
		v.setPrix(Double.parseDouble(prix));
		return v;
	}
	
}
