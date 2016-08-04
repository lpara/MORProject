package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="invetory")
public class Inventario {

	@Id
	@Column(name="inventory_id")
	private int id_inventario;
	
	@Column(name="film_id")
	private int id_filme;
	
	@Column(name="store_id")
	private int id_loja;

	public int getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}

	public int getId_filme() {
		return id_filme;
	}

	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}

	public int getId_loja() {
		return id_loja;
	}

	public void setId_loja(int id_loja) {
		this.id_loja = id_loja;
	}
	
	
}
