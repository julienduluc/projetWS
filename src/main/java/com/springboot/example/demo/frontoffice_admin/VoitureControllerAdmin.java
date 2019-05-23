package com.springboot.example.demo.frontoffice_admin;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springboot.example.demo.config.RoutesApi;
import com.springboot.example.demo.entities.Voiture;
import com.springboot.example.demo.services.VoitureServiceImpl;

@Controller
@RequestMapping(RoutesApi.BASE_URL_VOITURES_ADMIN)
public class VoitureControllerAdmin {

	private VoitureServiceImpl voitureService;

	@Autowired
	public VoitureControllerAdmin(final VoitureServiceImpl voitureService) {
		this.voitureService = voitureService;
	}

	@GetMapping()
	String rechercheVoitures(Model model, @RequestParam(value = "marque", defaultValue = "") String marque,
			@RequestParam(value = "modele", defaultValue = "") String modele,
			@RequestParam(value = "prixMin", defaultValue = "0") String prixMin,
			@RequestParam(value = "prixMax", defaultValue = "1000000000") String prixMax) {

		model.addAttribute("voitures", voitureService.rechercheVoitures(marque, modele, prixMin, prixMax));
		return "voitures";
	}

	@GetMapping("/edit/{voitureId}")
	String editVoitures(Model model, @PathVariable Integer voitureId) {
		Voiture v = voitureService.findById(voitureId);
		model.addAttribute("voiture", v);
        return "voitures_edit";
    }
    
    @PostMapping("/edit")
    public String editVoituresSubmit(@ModelAttribute Voiture voiture) throws JsonProcessingException  {
    	voitureService.editVoiturePrix(voiture.getId(), voiture.getPrix());
        return "redirect:/admin/voitures";
    }
    

	@GetMapping("/add")
	public String createVoiture(Model model) throws JsonProcessingException {
		Voiture v = new Voiture();
		model.addAttribute("voiture", v);
		return "voitures_create";
	}

	@PostMapping("/create")
	public String createVoitureSubmit(@ModelAttribute Voiture voiture, @RequestParam("file") MultipartFile file)
			throws JsonProcessingException {

		File convFile = new File(System.getProperty("java.io.tmpdir") + "/" + file);
		byte[] fileContent;

		try {
			file.transferTo(convFile);
			fileContent = FileUtils.readFileToByteArray(convFile);
			String encodedString = Base64.getEncoder().encodeToString(fileContent);

			byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
			FileUtils.writeByteArrayToFile(new File("src/main/resources/img/" + file.getOriginalFilename()), decodedBytes);

		} catch (IOException e) {
			e.printStackTrace();
		}
		voiture.setPhoto(file.getOriginalFilename());
		voitureService.saveVoiture(voiture);
		return "redirect:/admin/voitures";
	}

	@GetMapping("/delete/{voitureId}")
	String deleteVoitures(Model model, @PathVariable Integer voitureId) {
		Voiture v = voitureService.findById(voitureId);
		model.addAttribute("voiture", v);
		return "voitures_delete";
	}

	@PostMapping("/delete")
	public String deleteVoituresSubmit(@ModelAttribute Voiture voiture) throws JsonProcessingException {
		voitureService.deleteVoiture(voiture.getId());
		return "redirect:/admin/voitures";
	}
}
