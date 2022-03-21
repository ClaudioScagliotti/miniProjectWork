package it.es.gestionale.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name ="utente")
@Scope("Session")
public class UtenteEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String password;
    private String ruolo;

    @OneToOne(mappedBy = "utente")
    @JsonIgnore
	private DipendenteEntity dipendente;
    
    @OneToOne(mappedBy = "utente")
    @JsonIgnore
    private ClienteEntity cliente;

    public UtenteEntity(){
        
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public DipendenteEntity getDipendente() {
		return dipendente;
	}

	public void setDipendente(DipendenteEntity dipendente) {
		this.dipendente = dipendente;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "UtenteEntity [id=" + id + ", email=" + email + ", password=" + password + ", ruolo=" + ruolo
				+ ", dipendente=" + dipendente + ", cliente=" + cliente + "]";
	}

}