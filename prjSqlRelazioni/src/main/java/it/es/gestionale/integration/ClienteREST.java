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
import org.springframework.web.bind.annotation.SessionAttribute;
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
	public ResponseEntity<ClienteEntity> getCliente(@PathVariable("id") int id, @SessionAttribute UtenteEntity utente) {
		if(utente.getRuolo().equals("cliente")) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
		return ResponseEntity.ok(cServ.getCliente(id));
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ClienteJoin>> getClientiByNome(@PathVariable("nome")String nome, @SessionAttribute UtenteEntity utente){
		if(utente.getRuolo().equals("cliente")) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		return ResponseEntity.ok(cServ.getClienteByNome(nome));

	}
	
	@GetMapping("/cognome/{cognome}")
	public ResponseEntity<List<ClienteJoin>> getClientiByCognome(@PathVariable("cognome")String cognome, @SessionAttribute UtenteEntity utente){
		if(utente.getRuolo().equals("cliente")) {
		return ResponseEntity.ok(cServ.getClienteByCognome(cognome));
	}
		return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
	@GetMapping("/telefono/{telefono}")
	public ResponseEntity<List<ClienteJoin>> getClientiByTelefono(@PathVariable("telefono")String telefono, @SessionAttribute UtenteEntity utente){
		if(utente.getRuolo().equals("cliente")) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
		return ResponseEntity.ok(cServ.getClienteByTelefono(telefono));
	}	
	/*@GetMapping("/lista")
	public List<ClienteEntity> getAll(){
		return cServ.getAll();
	}*/

	@GetMapping("/lista")
	public ResponseEntity<List<ClienteJoin>> getAllClienteJoin(@SessionAttribute UtenteEntity utente){
		if(utente.getRuolo().equals("cliente")) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
		return ResponseEntity.ok(cServ.getAllClienteJoin());
	}	
		
	
	@GetMapping("/email/{email}")
	public ResponseEntity<List<ClienteJoin>> getByEmail(@PathVariable("email") String email, @SessionAttribute UtenteEntity utente) {
		if(utente.getRuolo().equals("cliente"))  {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
		return ResponseEntity.ok(cServ.getClienteByEmail(email));
	}	
	
	@PutMapping
	public ResponseEntity<ClienteEntity> updateCliente(@RequestBody ClienteEntity cliente, @SessionAttribute UtenteEntity utente) {
		if(utente.getRuolo().equals("cliente")) {
			ResponseEntity.status(HttpStatus.FORBIDDEN).build();
	}
		return ResponseEntity.ok(cServ.updateCliente(cliente));
		
	}	

	@PostMapping
	public void addCliente(@RequestBody ClienteEntity c, @SessionAttribute UtenteEntity utente) {
			cServ.addCliente(c);
	}	
}
