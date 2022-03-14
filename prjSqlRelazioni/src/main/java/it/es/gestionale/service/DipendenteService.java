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
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            return dipDB.findByNome();
        }

        return null;
        
    }

    public List<DipendenteEntity> getDipendentiByCognome(){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            return dipDB.findByCognome();
        }
        return null;
    }

    public List<DipendenteEntity> getDipendentiByRuolo(){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            return dipDB.findByRuolo();
        }
        

        return null;
    }

    public List<DipendenteEntity> getDipendentiByStipendio(double min,double max){
        if(dipente.getUtente_id().getRuolo().equals("supervisore")){
            return dipDB.findByStipendioBetween(min,max);
        }
        

        return null;
    }
}
