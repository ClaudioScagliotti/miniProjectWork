package it.es.gestionale.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "dipendente")
public class DipendenteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cognome;
	
	private String nome;

	@Column(name="rif_to")
	private Integer riferimento;
	
	private double stipendio;

	@ManyToOne
	@JoinColumn(name="ufficio_id")
	private UfficioEntity ufficio;

	@OneToMany(mappedBy ="dipendente")
	private List<OrdineEntity> ordini;

	@OneToOne
    @JoinColumn(name ="utente_id")
    private UtenteEntity utente;
	public List<OrdineEntity> getOrdini() {
		return ordini;
	}

	public UfficioEntity getUfficio() {
		return ufficio;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getRiferimento() {
		return riferimento;
	}

	public void setRiferimento(Integer riferimento) {
		this.riferimento = riferimento;
	}

	public double getStipendio() {
		return stipendio;
	}

	public void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public void setUfficio(UfficioEntity ufficio) {
		this.ufficio = ufficio;
	}

	public void setOrdini(List<OrdineEntity> ordini) {
		this.ordini = ordini;
	}
	public UtenteEntity getUtente() {
		return utente;
	}

	public void setUtente(UtenteEntity utente) {
		this.utente = utente;
	}
	
	
	
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "DipendenteEntity [id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", riferimento=" + riferimento
				+ ", stipendio=" + stipendio + "]";
	}
}
