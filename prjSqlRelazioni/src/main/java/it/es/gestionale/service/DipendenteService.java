package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.DipendenteEntity;
import it.es.gestionale.repository.DipendenteDB;

@Service
public class DipendenteService {
    
    @Autowired
    DipendenteDB dipDB;

    DipendenteEntity dipente;

    public List<DipendenteEntity> getDipendentiByNome(){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            return dipDB.findAllByOrderByNome();
        }

        return null;
        
    }

    public List<DipendenteEntity> getDipendentiByCognome(){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            return dipDB.findAllByOrderByCognome();
        }
        return null;
    }


    public List<DipendenteEntity> getDipendentiByStipendio(double min,double max){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            return dipDB.findByStipendioBetween(min,max);
        }
        

        return null;
    }
}
