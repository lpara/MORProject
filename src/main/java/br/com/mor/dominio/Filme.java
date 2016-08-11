package br.com.mor.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="film")
public class Filme {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="filme_seq")
	@SequenceGenerator(name="filme_seq", sequenceName="film_film_id_seq")
	@Column(name="film_id")
	private int id_filme;
	
	@Column(name="title")
	private String titulo;
	
	@Column(name="description")
	private String descricao;
	
	@Column(name="release_year")
	private int ano_lancamento;
	
	@ManyToOne
	@JoinColumn(name="language_id")
	private Idioma idioma;
	
	@Column(name="rental_duration")
	private int duracao_aluguel;
	
	@Column(name="rental_rate")
	private Number taxa_aluguel;
	
	@Column(name="length")
	private int duracao;
	
	@Column(name="replacement_cost")
	private Number custo_reposicao;
	
	@OneToOne
	@JoinTable(name="film_category", 
	joinColumns=@JoinColumn(name="film_id"),
	inverseJoinColumns=@JoinColumn(name="category_id"))
	private Categoria categoria;
	
	@ManyToMany
	@JoinTable(name="film_actor", 
	joinColumns=@JoinColumn(name="film_id"),
	inverseJoinColumns=@JoinColumn(name="actor_id"))
	private List<Ator> atores;
	
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

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

/*	public Ator getAtor() {
		return ator;
	}

	public void setAtor(Ator ator) {
		this.ator = ator;
	}*/

}
