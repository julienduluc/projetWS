package com.springboot.example.demo.repositories;


import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Repository;

import com.springboot.example.demo.entities.Vente;
import com.springboot.example.demo.entities.Voiture;

@Repository
public class VoitureRepositoryInMemory implements VoitureRepository {
	private Map<Integer, Voiture> voitures;
	private Map<Integer, Voiture> photosVoitures;


	public VoitureRepositoryInMemory() {
		this.voitures = new HashMap<>();
		this.photosVoitures = new HashMap<>();
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
		encodePhotoVoiture(voiture);
		this.voitures.put(i, voiture);
		
		return voiture;
	}

	@Override
	public void saveVoitures(List<Voiture> voitures) {		 
		for(Voiture v : voitures) {
			this.voitures.put(v.getId(), v);
		}
		encodePhotoVoiture(null);
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


	@Override
	public Voiture editVoiturePrix(Integer id, double prix) {
		Voiture v = findById(id);
		v.setPrix(prix);
		return v;
	}


	/** Peuple la Map photoVoitures :
	 * clé : voitureId, valeur : Objet Voiture
	 * la propriété photo contient la base64 de l'image de la voiture
	 * 
	 */
	@Override
	public void encodePhotoVoiture(Voiture vo) {
		String path = "src/main/resources/img/";
		if (vo == null) {
			voitures.forEach((v, k) -> {
			File convFile = new File(path + k.getPhoto());
			try {
				byte[] fileContent = FileUtils.readFileToByteArray(convFile);
				String encodedString = Base64.getEncoder().encodeToString(fileContent);
				Voiture newVoiture = new Voiture();
				newVoiture.setPhoto(encodedString);
				newVoiture.setModele(k.getModele());
				photosVoitures.put(k.getId(), newVoiture);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		});
		} else {
			File convFile = new File(path + vo.getPhoto());
			try {
				byte[] fileContent = FileUtils.readFileToByteArray(convFile);
				String encodedString = Base64.getEncoder().encodeToString(fileContent);
				Voiture newVoiture = new Voiture();
				newVoiture.setPhoto(encodedString);
				newVoiture.setModele(vo.getModele());
				photosVoitures.put(vo.getId(), newVoiture);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
	}


	@Override
	public Collection<Voiture> findPhotos() {
		return photosVoitures.values();
	}

	@Override
	public Voiture editVoiturePrixQuantite(Integer id, double prix, Integer quantiteRestante) {
		Voiture v = findById(id);
		v.setPrix(prix);
		v.setQuantiteRestante(v.getQuantiteRestante()+quantiteRestante);
		return v;
	}
}
