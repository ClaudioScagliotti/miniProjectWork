package it.es.gestionale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.es.gestionale.model.ClienteJoin;

public interface ClienteJoinDB extends JpaRepository<ClienteJoin, Integer> {
	
	List<ClienteJoin> findByEmail(String email);
	List<ClienteJoin> findByNome(String nome);
	List<ClienteJoin> findByCognome(String cognome);
	List<ClienteJoin> findByTelefono(String telefono);

}
