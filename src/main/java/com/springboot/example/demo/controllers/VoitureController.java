package com.springboot.example.demo.controllers;

import java.util.Collection;
import java.util.LinkedHashMap;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
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
