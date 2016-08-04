package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Loja {

	@Id
	@Column(name="store_id")
	private int id_loja;
	
	@Column(name="manager_staff_id")
	private int id_gerente_equipe;
	
	@Column(name="address_id")
	private int id_endereco;

	public int getId_loja() {
		return id_loja;
	}

	public void setId_loja(int id_loja) {
		this.id_loja = id_loja;
	}

	public int getId_gerente_equipe() {
		return id_gerente_equipe;
	}

	public void setId_gerente_equipe(int id_gerente_equipe) {
		this.id_gerente_equipe = id_gerente_equipe;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}
}
