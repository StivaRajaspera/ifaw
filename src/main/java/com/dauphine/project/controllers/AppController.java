package com.dauphine.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.dauphine.project.service.DevisService;

import com.dauphine.project.entity.DemandeDevis;

@Controller
public class AppController {
	
	@Autowired
	private DevisService devisService;
	
	@GetMapping({"/","/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping("/demanderDevis")
	public String demanderDevis(Model model) {
		model.addAttribute("demandeDevis", new DemandeDevis());
		return "demanderDevis";
	}
	
	@PostMapping("/demanderDevis")
	public String createDevis(DemandeDevis demandeDevis, Model model) {
		devisService.createDemandeDevis(demandeDevis);
		model.addAttribute("message", "Bravo, votre demande est envoyé !");
		return "demanderDevis";
	}
	
	@GetMapping("/consulterDevis")
	public String consulterDevis() {
		return "consulterDevis";
	}
	
	
	@GetMapping("/serviceTechnique")
	public String serviceTechnique() {
		return "serviceTechnique";
	}
}
