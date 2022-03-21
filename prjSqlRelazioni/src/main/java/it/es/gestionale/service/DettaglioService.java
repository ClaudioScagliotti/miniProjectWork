package it.es.gestionale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.DettaglioEntity;
import it.es.gestionale.repository.DettaglioDB;

@Service
public class DettaglioService {
    
    @Autowired
    DettaglioDB detDB;
   

    public DettaglioEntity updateOrdine (DettaglioEntity ordine) {
		return detDB.save(ordine);
	}
}
