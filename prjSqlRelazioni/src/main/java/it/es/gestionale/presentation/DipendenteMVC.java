package it.es.gestionale.presentation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.service.DipendenteService;

@Controller
@RequestMapping("dipendente")
@SessionAttributes("utenteSession")
public class DipendenteMVC {

    @Autowired
    DipendenteService srv;

    @GetMapping
    public String homeDipendente(@ModelAttribute ("utenteSession") UtenteEntity utente,Model m){
       if(utente.getRuolo().equals("impiegato")){
        m.addAttribute("dipendente",utente.getDipendente().getCognome());
        return "homeImpiegato";
       }else{
        m.addAttribute("dipendente",utente.getDipendente().getCognome());
        return "homeSupervisore";
       } 
    }
    
   /* @GetMapping("/prova")
    public String ottieniCliente(Model m, HttpSession session) {
    	
    	UtenteEntity u = (UtenteEntity) session.getAttribute("utente");
        ClienteEntity c=srv.getClienteByUtente(u);
        
        m.addAttribute("formCliente", c);
        
        return "anagraficaCliente";
    	
    }*/
    
}