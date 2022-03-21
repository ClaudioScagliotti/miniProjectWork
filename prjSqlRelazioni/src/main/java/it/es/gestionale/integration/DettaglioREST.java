package it.es.gestionale.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.es.gestionale.model.DettaglioEntity;
import it.es.gestionale.service.DettaglioService;

@RestController
public class DettaglioREST {
    
    @Autowired
    DettaglioService srv;

    @PutMapping
	public void updateCliente(@RequestBody DettaglioEntity ordine) {
		srv.updateOrdine(ordine);
	}

}
