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
        if(dipente.getUtente_id() != 0){}
        return dipDB.findByNome();
    }

    public List<DipendenteEntity> getDipendentiByCognome(){
        return dipDB.findByCognome();
    }

    public List<DipendenteEntity> getDipendentiByRuolo(){
        return dipDB.findByRuolo();
    }

    public List<DipendenteEntity> getDipendentiByStipendio(double min,double max){
        return dipDB.findByStipendioBetween(min,max);
    }
}
