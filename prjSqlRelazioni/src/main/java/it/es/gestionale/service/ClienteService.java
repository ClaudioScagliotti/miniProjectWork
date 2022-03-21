package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.ClienteEntity;
import it.es.gestionale.model.ClienteJoin;
import it.es.gestionale.model.UtenteEntity;
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
	
	public List<ClienteJoin> getClienteByNome(String nome) {
		
		return cjDB.findByNome(nome);
	}
	
	public List<ClienteJoin> getClienteByCognome(String cognome) {
			
			return cjDB.findByCognome(cognome);
		}
	
	public List<ClienteJoin> getClienteByTelefono(String telefono) {
		
	return cjDB.findByTelefono(telefono);
}
	public List<ClienteJoin> getClienteByEmail(String email) {
		
		return cjDB.findByEmail(email);
	}
	
	public List<ClienteJoin> getAllClienteJoin(){
		
		return cjDB.findAll();
	}
	
	public ClienteEntity updateCliente (ClienteEntity cliente) {
		return cDB.save(cliente);
	}

	public void addCliente(ClienteEntity c) {
		this.cDB.save(c);
	
		}
		public ClienteEntity getClienteByUtente(UtenteEntity utente) {
		
			return cDB.findByUtente(utente);
		}


	
	
}