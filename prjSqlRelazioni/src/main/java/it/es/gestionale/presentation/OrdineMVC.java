package it.es.gestionale.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.es.gestionale.model.UtenteEntity;
import it.es.gestionale.service.OrdineService;

@Controller
@RequestMapping("/ordini")
@SessionAttributes("utenteSession")
public class OrdineMVC {

    @Autowired
    OrdineService srv;


    @GetMapping
    public String get(Model model){

        model.addAttribute("ordini",srv.getAll());
        return "ordini";
    }

    @GetMapping("/ordine-cliente")
    public String getDettaglio(@ModelAttribute("utenteSession") UtenteEntity utente, Model model){

        switch(utente.getRuolo()) {
			
			case "cliente":
			model.addAttribute("ordini",srv.getDettaglio(utente.getCliente().getId()));
				break;
				
			case "impiegato":
            model.addAttribute("ordini",srv.getDettaglioByDipendente(utente.getDipendente().getId()));
                break;
				
			case "supervisore":
			model.addAttribute("ordini",srv.getAll());
                break;
			}
        return "ordini";
    }

}
