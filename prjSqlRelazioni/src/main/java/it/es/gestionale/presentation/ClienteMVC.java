package it.es.gestionale.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.es.gestionale.model.ClienteEntity;
import it.es.gestionale.model.ClienteUtente;
import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.service.ClienteService;

@Controller
@RequestMapping("login/cliente")
@SessionAttributes("utenteSession")
public class ClienteMVC {

    @Autowired
    ClienteService srv;
    
    
   /* @GetMapping("/prova")
    public String ottieniCliente(Model m, HttpSession session) {
    	
    	UtenteEntity u = (UtenteEntity) session.getAttribute("utente");
        ClienteEntity c=srv.getClienteByUtente(u);
        
        m.addAttribute("formCliente", c);
        
        return "anagraficaCliente";
    	
    }*/
    
    @GetMapping
    public String ottieniCliente(@ModelAttribute ("utenteSession") UtenteEntity utente, Model model) {
    	model.addAttribute("formCliente", srv.getClienteByUtente(utente));
    	model.addAttribute("formUtente", utente);
    	
    	
    	return "anagraficaCliente";
    }
   
    @PostMapping("/anagrafica") 
	public String updateCliente(@ModelAttribute UtenteEntity utenteForm, Model model, HttpSession session) {
    UtenteEntity u = (UtenteEntity) session.getAttribute("utente");
    ClienteEntity c=srv.getClienteByUtente(u);
    ClienteUtente cu= new ClienteUtente();
    model.addAttribute("cliente", c);
    model.addAttribute("utente", u);
    model.addAttribute("", cu);
    return "anagrafica";
    //TODO
    }
    
}
