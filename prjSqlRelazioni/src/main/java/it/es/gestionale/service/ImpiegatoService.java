package it.es.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.es.gestionale.model.ImpiegatoEntity;

import it.es.gestionale.repository.ImpiegatoDB;

@Service
public class ImpiegatoService {
    
    @Autowired
    ImpiegatoDB dipDB;

    ImpiegatoEntity dipente;

    public List<ImpiegatoEntity> getDipendentiByNome(){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            return dipDB.findAllByOrderByNome();
        }

        return null;
        
    }

    public List<ImpiegatoEntity> getDipendentiByCognome(){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            return dipDB.findAllByOrderByCognome();
        }
        return null;
    }


    public List<ImpiegatoEntity> getDipendentiByStipendio(double min,double max){
        if(dipente.getUtente().getRuolo().equals("supervisore")){
            return dipDB.findByStipendioBetween(min,max);
        }
        

        return null;
    }
}

