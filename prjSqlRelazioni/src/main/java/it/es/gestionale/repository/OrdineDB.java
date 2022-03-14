package it.es.gestionale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.es.gestionale.model.OrdineEntity;

@Repository
public interface OrdineDB extends JpaRepository<OrdineEntity, Integer>{
	
}

