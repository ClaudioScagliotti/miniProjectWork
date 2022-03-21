package it.es.gestionale.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.es.gestionale.model.DettaglioJoinEntity;
import it.es.gestionale.model.OrdineEntity;
import it.es.gestionale.model.OrdineJoinEntity;

@Repository
public interface OrdineDB extends JpaRepository<OrdineEntity, Integer>{

    
	@Query("select new it.es.gestionale.model.OrdineJoinEntity(o.id, d.cognome, c.cognome, (od.quantita*a.prezzo)) from OrdineEntity o, DipendenteEntity d, ClienteEntity c, DettaglioEntity od, ArticoloEntity a where o.dipendente=d.id and o.cliente=c.id and od.ordine=o.id and od.articolo=a.id")
	public List<OrdineJoinEntity> join();
/*
	@Query("select new it.es.gestionale.model.DettaglioJoinEntity(a.descrizione, (od.quantita*a.prezzo), od.quantita) from ArticoloEntity a, OrdineEntity o, DettaglioEntity od where od.articolo=a.id and od.ordine = o.id and o.id= :ordineId and o.cliente.id= :clienteId")
	public List<DettaglioJoinEntity> joinDettaglio(@Param("ordineId") int ordineId, @Param("clienteId") int clienteId);
*/
	@Query("select new it.es.gestionale.model.DettaglioJoinEntity(o.id, a.descrizione, (od.quantita*a.prezzo), od.quantita) from ArticoloEntity a, OrdineEntity o, DettaglioEntity od where od.articolo=a.id and od.ordine = o.id and o.cliente.id= :clienteId")
	public List<DettaglioJoinEntity> joinDettaglio(@Param("clienteId") int clienteId);

	@Query("select new it.es.gestionale.model.DettaglioJoinEntity(o.id, a.descrizione, (od.quantita*a.prezzo), od.quantita, o.cliente.id) from ArticoloEntity a, OrdineEntity o, DettaglioEntity od where od.articolo=a.id and od.ordine = o.id and o.dipendente.id= :dipendenteId")
	public List<DettaglioJoinEntity> joinDipendente(@Param("dipendenteId") int dipendenteId);
}

/* select ordine.id, (quantita*prezzo), dipendente.cognome, cliente.cognome from ordine join dipendente on ordine.dipendente_id=dipendente.id join cliente on ordine.cliente_id=cliente.id join ordine_dettaglio on ordine_dettaglio.ordine_id=ordine.id join  articolo on ordine_dettaglio.articolo_id=articolo.id;
*/

/*


select articolo.descrizione, (quantita*prezzo), ordine_dettaglio.quantita from articolo, ordine, ordine_dettaglio where ordine_dettaglio.articolo_id=articolo.id and ordine_dettaglio.ordine_id = ordine.id and ordine.id=7 and cliente_id=5; 
*/

/*
select new it.es.gestionale.model.DettaglioJoinEntity(o.id, a.descrizione, (od.quantita*a.prezzo), od.quantita from ArticoloEntity a, OrdineEntity o, DettaglioEntity od where od.articolo_id=a.id and od.ordine_id = o.id and o.cliente_id= :clienteId;
select new it.es.gestionale.model.DettaglioJoinEntity(a.descrizione, (od.quantita*a.prezzo), od.quantita) from ArticoloEntity a, OrdineEntity o, DettaglioEntity od where od.articolo=a.id and od.ordine = o.id and o.id= :ordineId and o.cliente.id= :clienteId
*/

/*
select articolo.descrizione, ordine_dettaglio.quantita, cliente.cognome from articolo, ordine, cliente, ordine_dettaglio where ordine_dettaglio.articolo_id=articolo.id and ordine.id=7 and ordine_dettaglio.ordine_id = ordine.id and ordine.cliente_id=cliente.id
*/

/*	
@Query(select p from Person p where p.forename = :forename and p.surname = :surname)
User findByForenameAndSurname(@Param("surname") String lastname,
                             @Param("forename") String firstname);
}
*/