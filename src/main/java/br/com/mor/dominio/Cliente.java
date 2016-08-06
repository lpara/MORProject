package br.com.mor.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Cliente {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_seq")
	@SequenceGenerator(name="cliente_seq", sequenceName="customer_customer_id_seq")
	@Column(name="cutomer_id")
	private int id_cliente;
	
	@Column(name="store_id")
	private int id_loja;
	
	@Column(name="first_name")
	private String nome;
	
	@Column(name="last_name")
	private String sobrenome;
	
	private String email;
	
	@Column(name="address_id")
	private int id_endereco;
	
	@Column(name="activebool")
	private boolean ativo;
	
	@Column(name="create_date")
	private Date data_cadastro;

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_loja() {
		return id_loja;
	}

	public void setId_loja(int id_loja) {
		this.id_loja = id_loja;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}
	
	
}
