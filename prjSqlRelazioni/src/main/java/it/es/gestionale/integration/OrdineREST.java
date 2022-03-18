package it.es.gestionale.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.es.gestionale.model.OrdineEntity;
import it.es.gestionale.service.OrdineService;

@RestController
@RequestMapping("/api/ordine")
public class OrdineREST {
	
	@Autowired
	private OrdineService serv;
	
	@GetMapping("/all")
	public List<OrdineEntity> getAll(){
		return serv.getordini();
	}
}
