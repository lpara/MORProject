package br.com.mor.dominio;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="film")
public class Filme {

	@Id
	@Column(name="film_id")
	private int id_filme;
	
	@Column(name="title")
	private String titulo;
	
	@Column(name="description")
	private String descricao;
	
	@Column(name="release_year")
	private int ano_lancamento;
	
	@Column(name="language_id")
	private int id_idioma;
	
	@Column(name="rental_duration")
	private int duracao_aluguel;
	
	@Column(name="rental_rate")
	private Number taxa_aluguel;
	
	@Column(name="length")
	private int duracao;
	
	@Column(name="replacement_cost")
	private Number custo_reposicao;

	public int getId_filme() {
		return id_filme;
	}

	public void setId_filme(int id_filme) {
		this.id_filme = id_filme;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(int ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}

	public int getId_idioma() {
		return id_idioma;
	}

	public void setId_idioma(int id_idioma) {
		this.id_idioma = id_idioma;
	}

	public int getDuracao_aluguel() {
		return duracao_aluguel;
	}

	public void setDuracao_aluguel(int duracao_aluguel) {
		this.duracao_aluguel = duracao_aluguel;
	}

	public Number getTaxa_aluguel() {
		return taxa_aluguel;
	}

	public void setTaxa_aluguel(Number taxa_aluguel) {
		this.taxa_aluguel = taxa_aluguel;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}

	public Number getCusto_reposicao() {
		return custo_reposicao;
	}

	public void setCusto_reposicao(Number custo_reposicao) {
		this.custo_reposicao = custo_reposicao;
	}
	
}
