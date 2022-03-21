package it.es.gestionale.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.es.gestionale.model.ClienteEntity;
import it.es.gestionale.model.ClienteJoin;
import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
@SessionAttributes("utente")
public class ClienteREST {
	
	@Autowired
	private ClienteService cServ;
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteEntity> getCliente(@PathVariable("id") int id, UtenteEntity utente) {
		if(!utente.getRuolo().equals("cliente")) {
		return ResponseEntity.ok(cServ.getCliente(id));
		}
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ClienteJoin>> getClientiByNome(@PathVariable("nome")String nome, UtenteEntity utente){
		if(!utente.getRuolo().equals("cliente")) {
		return ResponseEntity.ok(cServ.getClienteByNome(nome));
		}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

	}
	
	@GetMapping("/cognome/{cognome}")
	public ResponseEntity<List<ClienteJoin>> getClientiByCognome(@PathVariable("cognome")String cognome, UtenteEntity utente){
		if(!utente.getRuolo().equals("cliente")) {
		return ResponseEntity.ok(cServ.getClienteByCognome(cognome));
	}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
	@GetMapping("/telefono/{telefono}")
	public ResponseEntity<List<ClienteJoin>> getClientiByTelefono(@PathVariable("telefono")String telefono, UtenteEntity utente){
		if(!utente.getRuolo().equals("cliente")) {
		return ResponseEntity.ok(cServ.getClienteByTelefono(telefono));
	}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}	
	/*@GetMapping("/lista")
	public List<ClienteEntity> getAll(){
		return cServ.getAll();
	}*/

	@GetMapping("/lista")
	public ResponseEntity<List<ClienteJoin>> getAllClienteJoin(UtenteEntity utente){
		if(!utente.getRuolo().equals("cliente")) {
		return ResponseEntity.ok(cServ.getAllClienteJoin());
	}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}	
		
	
	@GetMapping("/email/{email}")
	public ResponseEntity<List<ClienteJoin>> getByEmail(@PathVariable("email") String email, UtenteEntity utente) {
		if(!utente.getRuolo().equals("cliente")) {
		return ResponseEntity.ok(cServ.getClienteByEmail(email));
	}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}	
	
	@PutMapping
	public ResponseEntity<Void> updateCliente(@RequestBody ClienteEntity cliente, UtenteEntity utente) {
		if(!utente.getRuolo().equals("cliente")) {
			ResponseEntity.ok(cServ.updateCliente(cliente));
	}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}	

	@PostMapping
	public ResponseEntity<Void> addCliente(@RequestBody ClienteEntity c, UtenteEntity utente) {
		if(!utente.getRuolo().equals("cliente")) {
			ResponseEntity.ok(cServ.addCliente(c));
	}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}	
}
