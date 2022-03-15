package it.es.gestionale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.es.gestionale.model.ImpiegatoEntity;

@Repository
public interface ImpiegatoDB extends JpaRepository<ImpiegatoEntity, Integer>{

    public List<ImpiegatoEntity> findAllByOrderByNome();

    public List<ImpiegatoEntity> findAllByOrderByCognome();

    public List<ImpiegatoEntity> findByStipendioBetween(double min,double max);
}

