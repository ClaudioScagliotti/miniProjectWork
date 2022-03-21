package it.es.gestionale.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.service.UtenteService;

@Controller
@RequestMapping("/login")
@SessionAttributes("utente")
public class UtenteMVC {
	
	@Autowired
	UtenteService usrv;
	
	@GetMapping
	public String get(Model model) {
		String titolo = "Inserisci le credenziali";
		
		model.addAttribute("utenteForm", new UtenteEntity());
		//Siccome useremo un oggetto per il controllo, dobbiamo istanziarlo di principio
		model.addAttribute("titolo", titolo);

		return "login"; 
	}
	
	@PostMapping("/login-utente") 
	public String loginUtente(@ModelAttribute UtenteEntity utenteForm, Model model, HttpSession session) {
		
		 // vedi consolese
		
		try {
			
			UtenteEntity utente = usrv.login(utenteForm); // restituisce utente se esiste, altrim lancia eccezione
			System.out.println("utente: " + utente);
			session.setAttribute("utente", utente); // aggiungo l'istanza dell'utente loggato alla sessione
			switch(utente.getRuolo()) {
			
			case "cliente":
				return "redirect:/cliente";
				
			case "impiegato":
				return "redirect:/dipendente";
				
			case "supervisore":
				return "redirect:/dipendente";
				
			default:
				return "redirect:/login";	
			}
			
		
			//return redirect consente di richiamare una rotta mappata all'interno di un controller
			//In questo caso chiediamo di dirigerci nella get mappata sotto lista-prodotti
			
		} catch(Exception e) {
			model.addAttribute("errore", e.getMessage());
			return get(model);
		}
	}

	/*
	@PostMapping("/login-utente") 
	public String loginUtente(@ModelAttribute UtenteEntity utenteForm, Model model, HttpSession session) {
		
		 // vedi consolese
		
		try {
			
			UtenteEntity utente = usrv.login(utenteForm); // restituisce utente se esiste, altrim lancia eccezione
			System.out.println("utente: " + utente);
			session.setAttribute("utenteSession", utente); // aggiungo l'istanza dell'utente loggato alla sessione
			switch(utente.getRuolo()) {
			
			case "cliente":
				return "redirect:/cliente";
				
			case "impiegato":
				return "redirect:/impiegato.html";
				
			case "supervisore":
				return "redirect:/supervisore.html";
			
			default:
				return "redirect:/login";
			}
			
					
			//return redirect consente di richiamare una rotta mappata all'interno di un controller
			//In questo caso chiediamo di dirigerci nella get mappata sotto lista-prodotti
			
		} catch(Exception e) {
			model.addAttribute("errore", e.getMessage());
			return get(model);
		}
	}
*/
	@GetMapping("/logout") //N.B: url è  "/login/logout"
	public String logout(HttpSession session) {
		
		session.invalidate(); // resetta la sessione e gli oggetti associati
		
		return "redirect:/";
	}
}
