package br.com.mor.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="actor")
public class Ator {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ator_seq")
	@SequenceGenerator(name="ator_seq", sequenceName="actor_actor_id_seq")
	@Column(name="actor_id")
	private int id_ator;
	
	@Column(name="first_name")
	private String primeiro_nome;
	
	@Column(name="last_name")
	private String ultimo_nome;
	
	@ManyToMany(mappedBy="atores")
	private List<Filme> filmes;
	
	public int getId_ator() {
		return id_ator;
	}

	public void setId_ator(int id_ator) {
		this.id_ator = id_ator;
	}

	public String getPrimeiro_nome() {
		return primeiro_nome;
	}

	public void setPrimeiro_nome(String primeiro_nome) {
		this.primeiro_nome = primeiro_nome;
	}

	public String getUltimo_nome() {
		return ultimo_nome;
	}

	public void setUltimo_nome(String ultimo_nome) {
		this.ultimo_nome = ultimo_nome;
	}

	public List<Filme> getFilme() {
		return filmes;
	}

	public void setFilme(List<Filme> filmes) {
		this.filmes = filmes;
	}
	
}
