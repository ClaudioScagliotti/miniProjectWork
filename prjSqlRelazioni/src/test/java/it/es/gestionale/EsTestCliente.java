package it.es.gestionale;


import java.util.List;

import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.repository.DipendenteDB;
import it.es.gestionale.repository.OrdineDB;
import it.es.gestionale.repository.UtenteDB;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
class EsTestCliente {
	@Autowired
	UtenteDB db;

	@Test
	@Transactional
	void findUtenti() {

		List<UtenteEntity> utenti =  db.findAll();
		
		System.out.println("--------------");
		for(UtenteEntity utente : utenti){
			if(utente.getRuolo().equals("impiegato"))
			System.out.println(utente.getEmail() + utente.getDipendente().getStipendio());
		}
		System.out.println("--------------");

	}
}
