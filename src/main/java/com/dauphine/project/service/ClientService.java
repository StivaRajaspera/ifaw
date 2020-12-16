package com.dauphine.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dauphine.project.entity.Client;
import com.dauphine.project.entity.DemandeDevis;
import com.dauphine.project.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client createClient(DemandeDevis demandeDevisDetails) {
//		User user = userRepository.findByEmail(userDetails.getEmail());
//		user.setUsername(userDetails.getUsername());
//		user.setPassword(bCryptPasswordEncoder().encode(userDetails.getPassword()));
//		return userRepository.save(user);
//		
		
		//DemandeDevis demandeDevis = devisRepository.findByEmail(demandeDevisDetails.getEmail());
		Client client = new Client(demandeDevisDetails.getNom(), demandeDevisDetails.getTelephone(), demandeDevisDetails.getAdresse(), demandeDevisDetails.getCode_postal(), demandeDevisDetails.getEmail());
		return clientRepository.save(client);
	}

}
