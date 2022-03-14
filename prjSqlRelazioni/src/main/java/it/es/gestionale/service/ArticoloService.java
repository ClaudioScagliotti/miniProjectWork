package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.ArticoloEntity;
import it.es.gestionale.repository.ArticoloDB;

@Service
public class ArticoloService {
	
	@Autowired
	ArticoloDB aDB;
	public List<ArticoloEntity> getAll(){
		return aDB.findAll();
	}
	
	public List<ArticoloEntity> getArticoloByDescrizione(String descrizione){
		
		return aDB.findByDescrizione(descrizione);
	}
	
	public List<ArticoloEntity> getArticoloByCategoria(String categoria){
		
		return aDB.findByCategoria(categoria);
	}
	
	public List<ArticoloEntity> getRangePrezzo(double min, double max){
		
		return aDB.findByPrezzoBetween(min, max);
	}
}
