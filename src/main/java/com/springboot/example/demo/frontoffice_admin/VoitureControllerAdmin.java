package com.springboot.example.demo.frontoffice_admin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping(RoutesApi.BASE_URL_VOITURES_ADMIN)
public class VoitureControllerAdmin {

	private VoitureServiceImpl voitureService;

    @Autowired
    public VoitureControllerAdmin(final VoitureServiceImpl voitureService){
        this.voitureService = voitureService;
    }

    @GetMapping()
    String rechercheVoitures(Model model, @RequestParam(value="marque", defaultValue="") String marque, 
    		@RequestParam(value="modele", defaultValue="") String modele, @RequestParam(value="prixMin", defaultValue="0") String prixMin,
    		@RequestParam(value="prixMax", defaultValue="1000000000") String prixMax){  
    	
        model.addAttribute("voitures", voitureService.rechercheVoitures(marque, modele, prixMin, prixMax));
        return "voitures";
    }	
    
    @GetMapping("/edit/{voitureId}")
    String editVoitures(Model model,@PathVariable Integer voitureId) {        
        model.addAttribute("voiture", voitureService.findById(voitureId));
        return "voitures_edit";
    }
    @PostMapping("/edit")
    public String handlePost(@RequestParam String action, Model m) {
        if( action.equals("save") ){
            //handle save
         }
         else if( action.equals("renew") ){
            //handle renew
         }
        System.out.println("action :" + action);
        voitureService.deleteVoiture(Integer.parseInt(action));
        m.addAttribute("voitures", voitureService.findAllVoitures());
        return "voitures_edit";
    }
	
}
