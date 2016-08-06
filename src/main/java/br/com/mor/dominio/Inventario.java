package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="invetory")
public class Inventario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="inventario_seq")
	@SequenceGenerator(name="inventario_seq", sequenceName="inventory_inventory_id_seq")
	@Column(name="inventory_id")
	private int id_inventario;
	
	@ManyToOne
	@JoinColumn(name="film_id")
	private Filme filme;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	private Loja loja;

	public int getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	
	
}
