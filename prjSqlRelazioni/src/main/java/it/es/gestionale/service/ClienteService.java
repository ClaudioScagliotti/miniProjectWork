package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.ClienteEntity;
import it.es.gestionale.model.ClienteJoin;
import it.es.gestionale.repository.ClienteDB;
import it.es.gestionale.repository.ClienteJoinDB;

@Service
public class ClienteService {
	
	@Autowired
	ClienteDB cDB;
	
	@Autowired
	ClienteJoinDB cjDB;
	
	public List<ClienteEntity> getAll(){
		return cDB.findAll();
	}
	
	public ClienteEntity getCliente(int id) {
		
		return cDB.findById(id).get();
	}
	
	public List<ClienteEntity> getClienteByNome(String nome) {
		
		return cDB.findByNome(nome);
	}
	
	public List<ClienteEntity> getClienteByCognome(String cognome) {
			
			return cDB.findByCognome(cognome);
		}
	
	public List<ClienteEntity> getClienteByTelefono(String telefono) {
		
	return cDB.findByTelefono(telefono);
}
	public ClienteJoin getClienteByEmail(String email) {
		
		return cjDB.findByEmail(email);
	}
	
	public List<ClienteJoin> getAllClienteJoin(){
		
		return cjDB.findAll();
	}
	
	public ClienteEntity updateCliente (ClienteEntity cliente) {
		return cDB.save(cliente);
	}


	
	
}
