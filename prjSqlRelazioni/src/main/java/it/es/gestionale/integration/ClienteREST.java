package it.es.gestionale.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.es.gestionale.model.ClienteEntity;
import it.es.gestionale.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteREST {
	
	@Autowired
	private ClienteService cServ;
	
	@GetMapping("/{id}")
	public ClienteEntity getCliente(@PathVariable("id") int id) {
		
		return cServ.getCliente(id);
	}
	
	@GetMapping("/nome/{nome}")
	public List<ClienteEntity> getClientiByNome(@PathVariable("nome")String nome){
		
		return cServ.getClienteByNome(nome);
	}
	
	@GetMapping("/cognome/{cognome}")
	public List<ClienteEntity> getClientiByCognome(@PathVariable("cognome")String cognome){
		
		return cServ.getClienteByCognome(cognome);
	}
	
	@GetMapping("/telefono/{telefono}")
	public List<ClienteEntity> getClientiByTelefono(@PathVariable("telefono")String telefono){
		
		return cServ.getClienteByTelefono(telefono);
	}
	

}
