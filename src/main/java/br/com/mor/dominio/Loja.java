package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="store")
public class Loja {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="loja_seq")
	@SequenceGenerator(name="loja_seq", sequenceName="store_store_id_seq")
	@Column(name="store_id")
	private int id_loja;
	
//	@OneToOne
//	@JoinColumn(name="manager_staff_id")
//	private Equipe gerente_equipe;
	
	@OneToOne
	@JoinColumn(name="address_id")
	private Endereco endereco;

	public int getId_loja() {
		return id_loja;
	}

	public void setId_loja(int id_loja) {
		this.id_loja = id_loja;
	}
//
//	public Equipe getGerente_equipe() {
//		return gerente_equipe;
//	}
//
//	public void setGerente_equipe(Equipe gerente_equipe) {
//		this.gerente_equipe = gerente_equipe;
//	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
}
