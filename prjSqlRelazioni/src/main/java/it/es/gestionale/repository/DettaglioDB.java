package it.es.gestionale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.es.gestionale.model.DettaglioEntity;
import it.es.gestionale.model.DettaglioKey;
@Repository
public interface DettaglioDB extends JpaRepository<DettaglioEntity, DettaglioKey>{
	
}

