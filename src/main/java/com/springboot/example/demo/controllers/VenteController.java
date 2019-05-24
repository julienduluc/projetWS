package com.springboot.example.demo.controllers;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.example.demo.config.RoutesApi;
import com.springboot.example.demo.entities.Vente;
import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.services.VenteServiceImpl;
import com.springboot.example.demo.services.VoitureServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(RoutesApi.BASE_URL_VENTES)
@Api(tags = "Vente Controller")
public class VenteController {

	private VenteServiceImpl venteService;
	private VoitureServiceImpl voitureService;

    @Autowired
    public VenteController(final VenteServiceImpl venteService, VoitureServiceImpl voitureService){
        this.venteService = venteService;
        this.voitureService = voitureService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Récupère une vente via son ID")
    Vente getVenteById(@PathVariable final int id) {
        return this.venteService.getVenteById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Ajoute une vente")
    Vente saveVente(@RequestBody Vente vente) {
    	Voiture v = voitureService.findById(vente.getVoiture().getId());
    	
    	if (v.getQuantiteRestante() > 0) {
    		
	    	vente.setVoiture(v);
	    	Calendar calendar = Calendar.getInstance();
	    	vente.setAnneeVente(calendar.get(Calendar.YEAR));
	        return this.venteService.saveVente(vente);
    	}
    	return null;
    }
   
    /**
     * Méthode non exposée dans l'API car réservée aux admins
     */
    /*
    @GetMapping(value = "/marque/{marque}")
    @ApiOperation(value = "Récupère les ventes d'une marque")
    Collection<Vente> getVentesByMarque(@PathVariable final String marque) {
        return this.venteService.getVentesByMarque(marque);
    }*/
    
    /**
     * Méthode non exposée dans l'API car réservée aux admins
     */
    /*
    @GetMapping(value = "/annee/{annee}")
    @ApiOperation(value = "Récupère les ventes d'une année")
    Collection<Vente> getVentesByAnnee(@PathVariable final Integer annee) {
        return this.venteService.getVentesByAnnee(annee);
    }*/
    
        /**
     * Méthode non exposée dans l'API car réservée aux admins
     */
    /*
    @GetMapping(value = "/chiffre_affaire/{annee}")
    @ApiOperation(value = "Récupère le chiffre d'affaire d'une année")
    double getTotalCAByAnnee(@PathVariable final Integer annee) {
        return this.venteService.getTotalCAByAnnee(annee);
    }*/
    
        /**
     * Méthode non exposée dans l'API car réservée aux admins
     */
    /*
    @GetMapping()
    @ApiOperation(value = "Filtre les ventes par marque et par année")
    Collection<Vente> rechercheVentes(@RequestParam(value="marque", defaultValue="") String marque,
    		@RequestParam(value="annee", defaultValue="2019") String annee) {
        return this.venteService.rechercheVentes(marque, annee);
    }*/
    
}
