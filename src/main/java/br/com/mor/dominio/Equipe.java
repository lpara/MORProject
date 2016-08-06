package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="staff")
public class Equipe {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="equipe_seq")
	@SequenceGenerator(name="equipe_seq", sequenceName="staff_staff_id_seq")
	@Column(name="staff_id")
	private int id_equipe;
	
	@Column(name="first_name")
	private String primeiro_nome;
	
	@Column(name="last_name")
	private String ultimo_nome;
	
	@ManyToOne
	@JoinColumn(name="address_id")
	private Endereco endereco;
	
	private String email;
	
	@OneToOne
	@JoinColumn(name="store_id")
	private Loja loja;
	
	@Column(name="active")
	private Boolean ativo;
	
	@Column(name="username")
	private String login;
	
	@Column(name="password")
	private String senha;

	public int getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}

	public String getPrimeiro_nome() {
		return primeiro_nome;
	}

	public void setPrimeiro_nome(String primeiro_nome) {
		this.primeiro_nome = primeiro_nome;
	}

	public String getUltimo_nome() {
		return ultimo_nome;
	}

	public void setUltimo_nome(String ultimo_nome) {
		this.ultimo_nome = ultimo_nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Loja getLoja() {
		return loja;
	}

	public void setLoja(Loja loja) {
		this.loja = loja;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
