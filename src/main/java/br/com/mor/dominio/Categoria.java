package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Categoria {

	@Id
	@Column(name="category_id")
	private int id_categoria;
	
	@Column(name="name")
	private String nome;

	public int getIdCategoria() {
		return id_categoria;
	}

	public void setIdCategoria(int id) {
		this.id_categoria = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}