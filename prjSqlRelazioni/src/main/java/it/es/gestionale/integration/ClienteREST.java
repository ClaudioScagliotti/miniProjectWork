package it.es.gestionale.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.es.gestionale.model.ClienteEntity;
import it.es.gestionale.model.ClienteJoin;
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
	
	@GetMapping("/lista")
	public List<ClienteEntity> getAll(){
		return cServ.getAll();
	}
	@GetMapping("/lista/all")
	public List<ClienteJoin> getAllClienteJoin(){
		return cServ.getAllClienteJoin();
	}
	
	@GetMapping("/email/{email}")
	public ClienteJoin getByEmail(@PathVariable("email") String email) {
		return cServ.getClienteByEmail(email);
	}
	
	@PutMapping
	public void updateCliente(@RequestBody ClienteEntity cliente) {
		cServ.updateCliente(cliente);
	}

}
