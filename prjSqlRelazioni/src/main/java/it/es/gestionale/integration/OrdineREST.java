package it.es.gestionale.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.es.gestionale.model.DettaglioJoinEntity;
import it.es.gestionale.model.OrdineJoinEntity;
import it.es.gestionale.service.OrdineService;

@RestController
@RequestMapping("/api/ordine")
public class OrdineREST {
	
	@Autowired
	private OrdineService serv;

	@GetMapping("ord")
	public List<OrdineJoinEntity> getOrdini(){

		return serv.getAll();
	}
/*
	@GetMapping("dettaglio/{ordineId}/{clienteId}")
	public List<DettaglioJoinEntity> getDettaglio(@PathVariable("ordineId")int ordineId, @PathVariable("clienteId")int clienteId){
		return serv.getDettaglio(ordineId, clienteId);
	}
*/
}
