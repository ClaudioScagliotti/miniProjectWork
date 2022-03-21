package it.es.gestionale.model;

public class InsertOrdineDTO {

    private String descrizione;
    private int quantita;
    private int cliente;
    
    public InsertOrdineDTO() {
    }

    public InsertOrdineDTO(String descrizione, int quantita, int cliente) {
        this.descrizione = descrizione;
        this.quantita = quantita;
        this.cliente = cliente;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
    
}
