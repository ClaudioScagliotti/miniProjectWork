package it.es.gestionale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.es.gestionale.model.ArticoloEntity;
import it.es.gestionale.model.DipendenteEntity;

@Repository
public interface DipendenteDB extends JpaRepository<DipendenteEntity, Integer>{
	
    public List<DipendenteEntity> findAllByOrderByNome();

    public List<DipendenteEntity> findAllByOrderByCognome();

    public List<DipendenteEntity> findAllByOrderBySettore();

    public List<DipendenteEntity> findByStipendioBetween(double min,double max);

}
