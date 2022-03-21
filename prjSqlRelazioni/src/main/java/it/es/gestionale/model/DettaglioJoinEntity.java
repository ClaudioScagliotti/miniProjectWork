package it.es.gestionale.model;

public class DettaglioJoinEntity {

    private int id;
    private String descrizione;
    private double prezzo;
    private int quantita;
    private int cliente;

    public DettaglioJoinEntity(String descrizione, double prezzo, int quantita) {
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public DettaglioJoinEntity(int id, String descrizione, double prezzo, int quantita) {
        this.id = id;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantita = quantita;
    }

    public DettaglioJoinEntity(int id, String descrizione, double prezzo, int quantita, int cliente) {
        this.id = id;
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        this.quantita = quantita;
        this.cliente = cliente;
    }

    public DettaglioJoinEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente= cliente;
    }

    public String getDescrizione() {
        return descrizione;
    }
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    public double getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
    public int getQuantita() {
        return quantita;
    }
    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }
}
