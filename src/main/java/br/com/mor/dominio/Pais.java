package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="country")
public class Pais {

	@Id
	@Column(name="country_id")
	private int id_pais;
	
	@Column(name="country")
	private String nome_pais;

	public int getId_pais() {
		return id_pais;
	}

	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}

	public String getNome_pais() {
		return nome_pais;
	}

	public void setNome_pais(String nome_pais) {
		this.nome_pais = nome_pais;
	}
}
