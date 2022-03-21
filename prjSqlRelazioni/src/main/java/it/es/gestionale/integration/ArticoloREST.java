package it.es.gestionale.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import it.es.gestionale.model.ArticoloEntity;
import it.es.gestionale.model.DipendenteEntity;
import it.es.gestionale.repository.DipendenteDB;
import it.es.gestionale.service.ArticoloService;
import it.es.gestionale.service.DipendenteService;

@RestController
@RequestMapping("/api/articolo")
public class ArticoloREST {
	
	@Autowired
	private ArticoloService serv;
	
	@GetMapping("/lista")
	public List<ArticoloEntity> getAll(){
		return serv.getAll();
	}
	
	@GetMapping("descrizione/{descrizione}")
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

	@PostMapping
	public void addArticolo(@RequestBody ArticoloEntity a){

		serv.addArticolo(a);
	}

	@PutMapping
	public void updArticolo(@RequestBody ArticoloEntity a){
		serv.updArticolo(a);
	}

	@GetMapping("/{id}")
	public ArticoloEntity getArticolo(@PathVariable("id") int id) {
		
		return serv.getArticolo(id);
	}

	@PostMapping("/import")
	public ResponseEntity insertCSV(@RequestPart("fileCSV") MultipartFile file) {
		
		serv.importCsv(file);
		return ResponseEntity.ok().build();	
	}

}
