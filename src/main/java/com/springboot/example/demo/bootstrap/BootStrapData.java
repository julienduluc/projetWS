package com.springboot.example.demo.bootstrap;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.example.demo.entities.Vente;
import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.repositories.VenteRepository;
import com.springboot.example.demo.repositories.VoitureRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	public final VenteRepository venteRepository;
	public final VoitureRepository voitureRepository;
	
	public BootStrapData(VenteRepository venteRepository, VoitureRepository voitureRepository) {
		this.venteRepository = venteRepository;
		this.voitureRepository = voitureRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		List<Vente> listeVentes = new ArrayList<>();
		List<Voiture> listeVoiture = new ArrayList<>();
		

    	try {
    		listeVentes = mapper.readValue(new File("datas/ventes.json"), new TypeReference<List<Vente>>() {});
    		listeVoiture = mapper.readValue(new File("datas/voitures.json"), new TypeReference<List<Voiture>>() {});
    		venteRepository.saveVentes(listeVentes);
    		voitureRepository.saveVoitures(listeVoiture);
	    	} catch (JsonParseException e) {			
				e.printStackTrace();
			} catch (JsonMappingException e) {			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
		} 
	}
}
