package it.es.gestionale.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="cliente")
public class ClienteEntity {
	  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cognome;
    private String nome;
    private String telefono;
    private String indirizzo;
    private String citta;
    private String provincia;
    private String regione;
    
    @OneToOne
    @JoinColumn(name="utente_id")
    @JsonIgnore
    private UtenteEntity utente;

	@OneToMany(mappedBy ="cliente")
	@JsonIgnore
	private List<OrdineEntity> ordini;
    
    
    public ClienteEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public UtenteEntity getUtente() {
		return utente;
	}

	public void setUtente(UtenteEntity utente) {
		this.utente = utente;
	}

	@Override
	public String toString() {
		return "ClienteEntity [id=" + id + ", cognome=" + cognome + ", nome=" + nome + ", telefono=" + telefono
				+ ", indirizzo=" + indirizzo + ", citta=" + citta + ", provincia=" + provincia + ", regione=" + regione
				+ "]";
	}
}
