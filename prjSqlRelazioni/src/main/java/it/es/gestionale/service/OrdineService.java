package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.OrdineEntity;
import it.es.gestionale.repository.OrdineDB;

@Service
public class OrdineService {
	
	@Autowired
	OrdineDB oDB;
	
	public List<OrdineEntity> getordini(){
		return oDB.findAll();
	}

}
