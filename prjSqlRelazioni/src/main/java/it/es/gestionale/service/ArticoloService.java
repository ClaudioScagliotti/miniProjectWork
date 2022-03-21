package it.es.gestionale.service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import it.es.gestionale.model.ArticoloEntity;
import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.repository.ArticoloDB;

@Service
public class ArticoloService {
	
	@Autowired
	ArticoloDB aDB;

	UtenteEntity ut;
	
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

	public void addArticolo(ArticoloEntity a){
		if(ut.getRuolo().equals("supervisore")){		
		this.aDB.save(a);
	}
	}

	public ArticoloEntity updArticolo(ArticoloEntity a){
		return this.aDB.save(a);
	}

	public ArticoloEntity getArticolo(int id) {
		
		return aDB.findById(id).get();
	}

	public void importCsv(MultipartFile file){
		
		try {
			
			InputStreamReader isr = new InputStreamReader(file.getInputStream(), "UTF-8"); //Permette di ottenere il flusso di dati
			BufferedReader buffer = new BufferedReader(isr); //Prassi per la lettura del flusso
						
			CsvToBean <ArticoloEntity> csv = new CsvToBeanBuilder(buffer)
					.withSeparator(';')
					.withIgnoreLeadingWhiteSpace(true)
					.withType(ArticoloEntity.class).build();
			List<ArticoloEntity> listaCsv =csv.parse();
			aDB.saveAll(listaCsv);
			
			
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
