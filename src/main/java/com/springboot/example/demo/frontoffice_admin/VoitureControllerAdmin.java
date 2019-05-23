package com.springboot.example.demo.frontoffice_admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.example.demo.config.RoutesApi;
import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.services.VoitureServiceImpl;

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
    	Voiture v = voitureService.findById(voitureId);
		model.addAttribute("voiture", v);
        return "voitures_edit";
    }
    
    @PostMapping("/edit")
    public String editVoituresSubmit(@ModelAttribute Voiture voiture) throws JsonProcessingException  {
    	voitureService.editVoiturePrix(voiture.getId(), voiture.getPrix());
        return "redirect:/admin/voitures";
    }
    
    /*@PostMapping("/create")
    public String createVoiture(@RequestParam("file") MultipartFile file) throws JsonProcessingException  {
    		
        return "redirect:/admin/voitures";
    }*/

    @GetMapping("/delete/{voitureId}")
    String deleteVoitures(Model model,@PathVariable Integer voitureId) {  
    	Voiture v = voitureService.findById(voitureId);
		model.addAttribute("voiture", v);
        return "voitures_delete";
    }
    
    @PostMapping("/delete")
    public String deleteVoituresSubmit(@ModelAttribute Voiture voiture) throws JsonProcessingException  {
    		//voitureService.deleteVoiture(voiture.getId());
    		System.out.println(voiture.getId());
        return "redirect:/admin/voitures";
    }
}
