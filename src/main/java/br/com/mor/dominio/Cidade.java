package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class Cidade {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cidade_seq")
	@SequenceGenerator(name="cidade_seq", sequenceName="city_city_id_seq")
	@Column(name="city_id")
	private int id_cidade;
	
	@Column(name="city")
	private String nome_cidade;
	
	@Column(name="country_id")
	private int id_pais;

	public int getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getNome_cidade() {
		return nome_cidade;
	}

	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}

	public int getId_pais() {
		return id_pais;
	}

	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
}
