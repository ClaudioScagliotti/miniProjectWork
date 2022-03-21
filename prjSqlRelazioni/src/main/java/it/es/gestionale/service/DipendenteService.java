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

    public List<DipendenteEntity> getDipendentiByNome(String nome){   
            return dipDB.findByNome(nome);
        
    }

    public List<DipendenteEntity> getDipendentiByCognome(String cognome){
            return dipDB.findByCognome(cognome);
    }


    public List<DipendenteEntity> getDipendentiByStipendio(double min,double max){
            return dipDB.findByStipendioBetween(min,max);
    }
}
