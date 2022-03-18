package it.es.gestionale.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ufficio")
public class UfficioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome", length = 50, nullable = true)
	private String nome;
	
	@OneToMany(mappedBy ="ufficio")
	private List<DipendenteEntity> impiegati;

	public List<DipendenteEntity> getImpiegati(){
		return impiegati;
	}
	
	public UfficioEntity() {}
	
	public UfficioEntity(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "UfficioEntity [id=" + id + ", nome=" + nome + ", impiegati=" + impiegati + "]";
	}

}
