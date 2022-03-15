package it.es.gestionale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.es.gestionale.model.ClienteJoin;

public interface ClienteJoinDB extends JpaRepository<ClienteJoin, Integer> {
	
	ClienteJoin findByEmail(String email);

}
