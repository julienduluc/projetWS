package com.springboot.example.demo.frontoffice_admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.example.demo.config.RoutesApi;
import com.springboot.example.demo.entities.Vente;
import com.springboot.example.demo.services.VenteServiceImpl;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
@RequestMapping(RoutesApi.BASE_URL_VENTES_ADMIN)
public class VenteControllerAdmin {

	private VenteServiceImpl venteService;

	@Autowired
	public VenteControllerAdmin(final VenteServiceImpl venteService){
		this.venteService = venteService;
	}

	@GetMapping()
	String rechercheVentes(Model model, @RequestParam(value="marque", defaultValue="") String marque, 
			@RequestParam(value="annee", defaultValue="2019") String annee) {  

		model.addAttribute("ventes", venteService.rechercheVentes(marque, annee));
		model.addAttribute("chiffre_affaire_annee", venteService.getTotalCAByAnnee(Integer.parseInt(annee)));
		model.addAttribute("annee", annee);
		return "ventes";
	}

	@GetMapping("/details/{id}")
	String detailsVente(Model model,@PathVariable Integer id) {  
		Vente v = venteService.getVenteById(id);
		model.addAttribute("vente", v);
		return "vente_details";
	}

	/*@PostMapping("/create")
    public String createVoiture(@RequestParam("file") MultipartFile file) throws JsonProcessingException  {

        return "redirect:/admin/voitures";
    }*/

}
