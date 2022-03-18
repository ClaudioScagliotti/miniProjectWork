package it.es.gestionale.presentation;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.es.gestionale.model.ClienteEntity;
import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteMVC {

    @Autowired
    ClienteService srv;
    @PostMapping("/anagrafica") 
	public String ottieniCliente(@ModelAttribute UtenteEntity utenteForm, Model model, HttpSession session) {
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
