package com.springboot.example.demo.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
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

    @GetMapping(value = "/{voitureId}")
    @ResponseBody
    @ApiOperation(value = "Récupère une voiture via son ID")
    Voiture getVoitureById(@PathVariable final int id) {
        return this.voitureService.findById(id);
    }

    @GetMapping()
    @ResponseBody
    @ApiOperation(value = "Récupère toutes les voitures")
    List<Voiture> getAllVoitures(Model model) {
    	model.addAttribute("catalogue", this.voitureService.findAllVoitures());
        return this.voitureService.findAllVoitures();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Ajoute une voiture dans le catalogue")
    void addVoiture(@RequestBody Voiture voiture){
        this.voitureService.saveVoiture(voiture);
    }
    
    @DeleteMapping("/{voitureId}")
    @ResponseBody
    @ApiOperation(value = "Supprime une voiture dans le catalogue")
    void deleteVoitureById(@PathVariable final int id){
        this.voitureService.deleteVoiture(id);
    }
    
    /*void reloadListeVoiture() {
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
    }*/
}
