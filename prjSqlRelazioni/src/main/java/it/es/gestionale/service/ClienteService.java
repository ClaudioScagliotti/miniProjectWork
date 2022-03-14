package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.ClienteEntity;
import it.es.gestionale.repository.ClienteDB;

@Service
public class ClienteService {
	
	@Autowired
	ClienteDB cDB;
	
	public List<ClienteEntity> getAll(){
		return cDB.findAll();
	}
}
