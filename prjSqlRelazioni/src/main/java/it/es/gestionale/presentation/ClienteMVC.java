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
import it.es.gestionale.service.UtenteService;

@Controller
@RequestMapping("cliente")
@SessionAttributes("utenteSession")
public class ClienteMVC {

    @Autowired
    ClienteService srv;
    
    @Autowired
    UtenteService uSrv;
    
    
   /* @GetMapping("/prova")
    public String ottieniCliente(Model m, HttpSession session) {
    	
    	UtenteEntity u = (UtenteEntity) session.getAttribute("utente");
        ClienteEntity c=srv.getClienteByUtente(u);
        
        m.addAttribute("formCliente", c);
        
        return "anagraficaCliente";
    	
    }*/
    
    @GetMapping
    public String homeCliente() {
    	return "homeCliente";
    }
    
    @GetMapping("/anagrafica")
    public String ottieniCliente(@ModelAttribute ("utenteSession") UtenteEntity utente, Model model) {
    	model.addAttribute("formCliente", srv.getClienteByUtente(utente));
    	model.addAttribute("formUtente", utente);
    	
    	
    	return "anagraficaCliente";
    }
   
    @PostMapping("/anagrafica/cliente") 
	public String updateCliente(@ModelAttribute("cliente") ClienteEntity cliente) {
    	srv.updateCliente(cliente);
    return "redirect:/cliente/anagrafica";
    
    }
    
  
    
    
}
