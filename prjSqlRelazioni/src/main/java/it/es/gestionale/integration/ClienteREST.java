package it.es.gestionale.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.es.gestionale.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteREST {
	
	@Autowired
	private ClienteService cServ;
	

}
