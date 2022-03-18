package it.es.gestionale.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.es.gestionale.model.ArticoloEntity;
import it.es.gestionale.service.ArticoloService;

@RestController
@RequestMapping("/api/articolo")
public class ArticoloREST {
	
	@Autowired
	private ArticoloService serv;
	
	@GetMapping
	public List<ArticoloEntity> getAll(){
		return serv.getAll();
	}
	
	@GetMapping("/{descrizione}")
	public List<ArticoloEntity> getByDescrizione(@PathVariable("descrizione") String descrizione){
		
		return serv.getArticoloByDescrizione(descrizione);
		
	}
	
	@GetMapping("categoria/{categoria}")
	public List<ArticoloEntity> getByCategoria(@PathVariable("categoria") String categoria){
		
		return serv.getArticoloByCategoria(categoria);
		
	}
	
	@GetMapping("/{min}/{max}")
	public List<ArticoloEntity> getPrezzoRange(@PathVariable("min")double min, @PathVariable("max")double max){
		return serv.getRangePrezzo(min, max);
	}
	

}
