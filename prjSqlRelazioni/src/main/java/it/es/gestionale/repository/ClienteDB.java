package it.es.gestionale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.es.gestionale.model.ClienteEntity;

@Repository
public interface ClienteDB extends JpaRepository<ClienteEntity, Integer> {
	
	List<ClienteEntity> findByNome(String nome);
	List<ClienteEntity> findByCognome(String cognome);
	List<ClienteEntity> findByTelefono(String telefono);
}
