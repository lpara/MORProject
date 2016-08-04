package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Endereco {

	@Id
	@Column(name="address_id")
	private int id_endereco;
	
	@Column(name="address")
	private String endereco;
	
	@Column(name="address2")
	private String endereco_secundario;
	
	@Column(name="district")
	private String bairro;
	
	@Column(name="city_id")
	private int id_cidade;
	
	@Column(name="postal_code")
	private String cep;
	
	@Column(name="phone")
	private String telefone;

	public int getId_endereco() {
		return id_endereco;
	}

	public void setId_endereco(int id_endereco) {
		this.id_endereco = id_endereco;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEndereco_secundario() {
		return endereco_secundario;
	}

	public void setEndereco_secundario(String endereco_secundario) {
		this.endereco_secundario = endereco_secundario;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public int getId_cidade() {
		return id_cidade;
	}

	public void setId_cidade(int id_cidade) {
		this.id_cidade = id_cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
