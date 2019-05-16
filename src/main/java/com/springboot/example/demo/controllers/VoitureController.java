package com.springboot.example.demo.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.entities.VoitureOccasion;
import com.springboot.example.demo.services.VoitureOccasionServiceImpl;
import com.springboot.example.demo.services.VoitureServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "Voiture Controller")
public class VoitureController {

	private VoitureOccasionServiceImpl voitureService;

    @Autowired
    public VoitureController(final VoitureOccasionServiceImpl voitureService){
        this.voitureService = voitureService;
        
        ObjectMapper mapper = new ObjectMapper();
        
        VoitureOccasion vo = new VoitureOccasion();
        vo.setId(9696);
        vo.setMarque("jjj");
        vo.setPrix(3.22);
        vo.setAnneeMiseEnCirculation(2130);
        vo.setCouleur("rouge");
        
        ArrayList<VoitureOccasion> listeVoitures = new ArrayList<VoitureOccasion>();
        
        
        
        try {
			reloadListeVoiture();
			
			
			listeVoitures.add(vo);
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("datas/voitureOccasion.json"), listeVoitures);
			
		} catch (JsonParseException e) {			
			e.printStackTrace();
		} catch (JsonMappingException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
        
    }

    @GetMapping(value = "/voiture/{voitureId}")
    @ResponseBody
    @ApiOperation(value = "Récupère une voiture via son ID")
    VoitureOccasion getVoitureById(@PathVariable final Integer voitureId) {
    	reloadListeVoiture();
        return this.voitureService.getVoitureById(voitureId);
    }

    @GetMapping(value = "/voitures")
    @ResponseBody
    @ApiOperation(value = "Récupère toutes les voitures")
    List<VoitureOccasion> getAllVoitures() {
    	reloadListeVoiture();
        return this.voitureService.getAllVoitures();
    }

    @PostMapping(value = "/voiture")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Ajoute une voiture dans le catalogue")
    void addVoiture(@RequestBody VoitureOccasion voiture){
        this.voitureService.addVoiture(voiture);
    }
    
    @DeleteMapping(value = "/voiture/{voitureId}")
    @ResponseBody
    @ApiOperation(value = "Supprime une voiture dans le catalogue")
    void deleteVoitureById(@PathVariable final Integer voitureId){
        this.voitureService.deleteVoiture(voitureId);
    }
    
    void reloadListeVoiture() {
    	ArrayList<VoitureOccasion> listeVoitures = new ArrayList<VoitureOccasion>();
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try {
    	listeVoitures = mapper.readValue(new File("datas/voitureOccasion.json"), new TypeReference<ArrayList<VoitureOccasion>>() {});
		
		voitureService.viderListeVoiture();
		voitureService.addVoitures(listeVoitures);
		
    	} catch (JsonParseException e) {			
			e.printStackTrace();
		} catch (JsonMappingException e) {			
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
    }
}
