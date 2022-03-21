package it.es.gestionale.model;

public class OrdineJoinEntity {

    private int id;
    private String dipendente;
    private String cliente;
    private double valore;

  
    public OrdineJoinEntity() {
    }

    public OrdineJoinEntity(int id, String dipendente, String cliente, double valore) {
        this.id = id;
        this.dipendente = dipendente;
        this.cliente = cliente;
        this.valore = valore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValore() {
        return valore;
    }

    public void setValore(double valore) {
        this.valore = valore;
    }

    public String getDipendente() {
        return dipendente;
    }

    public void setDipendente(String dipendente) {
        this.dipendente = dipendente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
}
