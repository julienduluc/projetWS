package com.springboot.example.demo.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
    
    @GetMapping(value = "/photos")
    @ResponseBody
    @ApiOperation(value = "Filtre les voitures")
    Collection<Voiture> getAllPhotos() {
        return this.voitureService.findPhotos();
        
    }
    
    /**
     * Méthode non exposée dans l'API car réservée aux admins
     */
    /*@PostMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Ajoute une voiture dans le catalogue")
    void addVoiture(@RequestBody Voiture voiture){
        this.voitureService.saveVoiture(voiture);
    }
    */
    
    /**
     * Méthode non exposée dans l'API car réservée aux admins
     */
    /*@DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Supprime une voiture dans le catalogue")
    void deleteVoitureById(@PathVariable final int id){
    	ObjectMapper mapper = new ObjectMapper();
    	if (reloadListeVoiture(id)) {
    		this.voitureService.deleteVoiture(id);
    	}       
    }*/
    
    /**
     * Méthode non exposée dans l'API car réservée aux admins
     */
    /*@PatchMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Modifie le prix d'une voiture")
    Voiture patchVoiture(@PathVariable final int id, @RequestParam(value="prix", defaultValue="") double prix,
    @RequestParam(value="quantite", defaultValue="") int quantite) {
        return this.voitureService.editVoiturePrixQuantite(id, prix, quantite);
    }*/ 
}
