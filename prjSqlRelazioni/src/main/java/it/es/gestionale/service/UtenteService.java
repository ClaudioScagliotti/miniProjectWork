package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.repository.UtenteDB;

@Service
public class UtenteService {
	
	@Autowired
	UtenteDB uDB;
	
	public List<UtenteEntity> getUtenti(){
		return uDB.findAll();
	}
	
	public UtenteEntity login(UtenteEntity ut) throws Exception {
		
		List<UtenteEntity> lista = uDB.findAll(); // -> fa in automatico la query per tirare dati dalla tabella utente
		
		for (UtenteEntity utente : lista) {
			
			if(utente.getEmail().equals(ut.getEmail())) { //Esiste un utente con quella password?
				
				if(utente.getPassword().equals(ut.getPassword())) { //Se esiste, la password inserita è corretta?
					
					return utente;
					
				}
			}
			
		}
		
		throw new Exception("Credenziali errate.");
	}
	
	public void registraUtente(UtenteEntity input) {
		
		uDB.save(input); 
	}

}
