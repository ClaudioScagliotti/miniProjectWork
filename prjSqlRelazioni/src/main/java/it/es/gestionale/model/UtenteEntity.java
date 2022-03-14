package it.es.gestionale.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

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
	private DipendenteEntity dipendente;
    
    @OneToOne(mappedBy = "utente")
    private ClienteEntity cliente;

    @OneToMany(mappedBy = "utente")
    private List<OrdineEntity> ordini;

    public UtenteEntity(){
        
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
    
    public void setOrdini(List<OrdineEntity> ordini) {
        this.ordini = ordini;
    }

    public List<OrdineEntity> getOrdini() {
        return ordini;
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
				+ ", dipendente=" + dipendente + ", cliente=" + cliente + ", ordini=" + ordini + "]";
	}

}
