package com.dauphine.project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dauphine.project.service.DevisService;
import com.dauphine.project.entity.Client;
import com.dauphine.project.entity.DemandeDevis;
import com.dauphine.project.service.ClientService;
@RestController
public class DemandeDevisController {
	
	@Autowired
	private DevisService devisService;
	
	@Autowired
	public JavaMailSender javaMailSender;
	
	@Autowired
	private ClientService clientService;
	

	@RequestMapping("/getAllDemandeDevis")
    public List<DemandeDevis> getAllDemandeDevis() {
        return devisService.getAllDemandeDevis();
    }
	
	@RequestMapping(value = "/enregistrerClient", method = RequestMethod.POST)
	public Client enregistrerClient1(@RequestBody DemandeDevis demandeDevis) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(""+demandeDevis.getEmail());
//		message.setSubject("Votre demande de devis a été validée");
//		message.setText("Bonjour "+demandeDevis.getNom()+","+"\n\n"+"VOTRE DEMANDE A BIEN ÉTÉ PRISE EN COMPTE ET NOUS VOUS EN REMERCIONS." +
//				"\n"+ "Indiquez les créneaux de RDV où vous êtes disponible. Une fois le RDV valide, vous recevrez un expert pour qu'il "
//				+ "établisse un devis de travaux sur mesure." +
//				"\n\n"+"Toute l’équipe de RENOPART vous remercie de votre confiance."+"\n\n" 
//						+"Bien cordialement," + "\n" + 
//						"L’équipe RENOPART.");
//		javaMailSender.send(message);
//		System.out.println("***************************envoyé");
		devisService.deleteDemandeDevis(demandeDevis);
		return clientService.createClient(demandeDevis);	
	}
	
	@RequestMapping(value = "/supprimerDemandeDevis", method = RequestMethod.POST)
	public void supprimerDemandeDevis(@RequestBody DemandeDevis demandeDevis) {
//		SimpleMailMessage message = new SimpleMailMessage();
//		message.setTo(""+demandeDevis.getEmail());
//		message.setSubject("Votre demande de devis incomplète");
//		message.setText("Bonjour "+demandeDevis.getNom()+","+"\n\n"+"VOTRE DEMANDE N'A PAS PU ETRE VALIDEE A CAUSE DES INFORMATIONS INCOMPLETES." +
//				"\n"+ "Veuillez refaire votre demande sur notre site" +
//				"\n\n"+"Toute l’équipe de RENOPART vous remercie de votre confiance."+"\n\n" 
//						+"Bien cordialement," + "\n" + 
//						"L’équipe RENOPART.");
//		javaMailSender.send(message);
//		System.out.println("***************************envoyé");
		devisService.deleteDemandeDevis(demandeDevis);
	
	}
	
	
}