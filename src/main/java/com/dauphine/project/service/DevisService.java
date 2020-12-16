package com.dauphine.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dauphine.project.entity.DemandeDevis;
import com.dauphine.project.repository.DevisRepository;

@Service
public class DevisService {
	
	@Autowired
	private DevisRepository devisRepository;
	
	public DemandeDevis createDemandeDevis(DemandeDevis demandeDevis) {
		return devisRepository.save(demandeDevis);
	}

	public void deleteDemandeDevis(DemandeDevis demandeDevis) {
		devisRepository.delete(demandeDevis);
	}
	
	public List<DemandeDevis> getAllDemandeDevis() {
		
		List<DemandeDevis> listeDemandeDevis =  new ArrayList<> ((List<DemandeDevis>) devisRepository.findAll());	
		return listeDemandeDevis;
	}

}
