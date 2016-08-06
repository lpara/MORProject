package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="category")
public class Categoria {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="categoria_seq")
	@SequenceGenerator(name="categoria_seq", sequenceName="category_category_id_seq")
	@Column(name="category_id")
	private int id_categoria;
	
	@Column(name="name")
	private String nome;
	
	@Transient
	private Filme filme;

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

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}
}
