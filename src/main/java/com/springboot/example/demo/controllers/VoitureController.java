package com.springboot.example.demo.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.example.demo.config.RoutesApi;
import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.services.VoitureServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping(RoutesApi.BASE_URL_VOITURES)
@Api(tags = "Voiture Controller")
public class VoitureController {

	private VoitureServiceImpl voitureService;

    @Autowired
    public VoitureController(final VoitureServiceImpl voitureService){
        this.voitureService = voitureService;
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    @ApiOperation(value = "Récupère une voiture via son ID")
    Voiture getVoitureById(@PathVariable final Integer id) {
        return this.voitureService.findById(id);
    }

    @GetMapping()
    @ResponseBody
    @ApiOperation(value = "Filtre les voitures")
    Collection<Voiture> rechercheVoitures(@RequestParam(value="marque", defaultValue="") String marque, 
    		@RequestParam(value="modele", defaultValue="") String modele, @RequestParam(value="prixMin", defaultValue="0") String prixMin,
    		@RequestParam(value="prixMax", defaultValue="1000000000") String prixMax) {
        return this.voitureService.rechercheVoitures(marque, modele, prixMin, prixMax);
        
    }
    
    @GetMapping(value = "/photos")
    @ResponseBody
    @ApiOperation(value = "Filtre les voitures")
    Collection<Voiture> getAllPhotos() {
        return this.voitureService.findPhotos();
        
    }
    

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Ajoute une voiture dans le catalogue")
    void addVoiture(@RequestBody Voiture voiture){
        this.voitureService.saveVoiture(voiture);
    }
    
    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Supprime une voiture dans le catalogue")
    void deleteVoitureById(@PathVariable final int id){
    	ObjectMapper mapper = new ObjectMapper();
    	if (reloadListeVoiture(id)) {
    		this.voitureService.deleteVoiture(id);
    	}
    	try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("datas/voitureOccasion.json"), voitureService.findAllVoitures());
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
    }
       
    @PatchMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Modifie le prix d'une voiture")
    Voiture patchVoiture(@PathVariable final int id, @RequestParam(value="prix", defaultValue="") String prix) {
        return this.voitureService.editVoiturePrix(id, prix);
        
    }
    
    boolean reloadListeVoiture(Integer id) {
    	List<Voiture> listeVoiture = new ArrayList<>();
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try {
    		listeVoiture = mapper.readValue(new File("datas/voitures.json"), new TypeReference<List<Voiture>>() {});
    		voitureService.saveVoitures(listeVoiture);
    		if (voitureService.findById(id) != null) {
    			return true;
    		} else {
    			return false;
    		}
    		
	    	} catch (JsonParseException e) {			
				e.printStackTrace();
				return false;
			} catch (JsonMappingException e) {			
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
		} 
    }
    
   
}
