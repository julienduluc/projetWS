package com.springboot.example.demo.controllers;

import java.util.List;

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
import com.springboot.example.demo.services.VenteServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(RoutesApi.BASE_URL_VENTES)
@Api(tags = "Vente Controller")
public class VenteController {

	private VenteServiceImpl venteService;

    @Autowired
    public VenteController(final VenteServiceImpl venteService){
        this.venteService = venteService;
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Récupère une vente via son ID")
    Vente getVenteById(@PathVariable final int id) {
        return this.venteService.getVenteById(id);
    }

    @GetMapping()
    @ApiOperation(value = "Récupère toutes les ventes")
    List<Vente> getAllVentes() {
        return this.venteService.findAllVentes();
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Ajoute une vente")
    Vente saveVente(@RequestBody Vente vente){
    	
        return this.venteService.saveVente(vente);
      /*  ObjectMapper mapper = new ObjectMapper();
        try {
			mapper.writerWithDefaultPrettyPrinter().writeValue(new File("datas/ventes.json"), this.venteService.getAllVentes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
   
    
   /* void reloadListeVentes() {
    	ArrayList<Vente> listeVentes = new ArrayList<Vente>();
    	ObjectMapper mapper = new ObjectMapper();
    	
    	try {
    		listeVentes = mapper.readValue(new File("datas/ventes.json"), new TypeReference<ArrayList<Vente>>() {});
			
    		venteService.addVentes(listeVentes);
			
	    	} catch (JsonParseException e) {			
				e.printStackTrace();
			} catch (JsonMappingException e) {			
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
		} 
    }*/
}
