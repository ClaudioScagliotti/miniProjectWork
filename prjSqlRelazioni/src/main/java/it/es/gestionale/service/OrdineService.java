package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.DettaglioJoinEntity;
import it.es.gestionale.model.OrdineJoinEntity;
import it.es.gestionale.repository.OrdineDB;

@Service
public class OrdineService {
	
	@Autowired
	OrdineDB oDB;
	

	public List<OrdineJoinEntity> getAll(){
		return oDB.join();
	}
/*
	public List<DettaglioJoinEntity> getDettaglio(int ordineId, int clienteId){
		return oDB.joinDettaglio(ordineId, clienteId);
	}
*/
	public List<DettaglioJoinEntity> getDettaglio(int clienteId){
		return oDB.joinDettaglio(clienteId);
	}

public List<DettaglioJoinEntity> getDettaglioByDipendente(int dipendenteId){
	return oDB.joinDipendente(dipendenteId);
}
}
