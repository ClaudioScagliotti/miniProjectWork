package it.es.gestionale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="dipendente")
public class DipendenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String cognome;

    private int rif_to;
    private double stipendio;

    @OneToOne(mappedBy = "utente")
	@JoinColumn(name ="id")
    private UtenteEntity utente_id;


	@OneToOne(mappedBy = "ufficio")
	@JoinColumn(name = "id")
    private int ufficio_id;
	

	public UtenteEntity getUtente_id() {
		return utente_id;
	}

	public void setUtente_id(UtenteEntity utente_id) {
		this.utente_id = utente_id;
	}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public int getRif_to() {
        return rif_to;
    }

    public void setRif_to(int rif_to) {
        this.rif_to = rif_to;
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public int getUfficio_id() {
        return ufficio_id;
    }

    public void setUfficio_id(int ufficio_id) {
        this.ufficio_id = ufficio_id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "DipendenteEntity [cognome=" + cognome + ", id=" + id + ", nome=" + nome + ", rif_to=" + rif_to
                + ", stipendio=" + stipendio + ", ufficio_id=" + ufficio_id + ", utente_id=" + utente_id + "]";
    }

  
    

}
