package br.com.mor.dominio;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="language")
public class Idioma {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="idioma_seq")
	@SequenceGenerator(name="idioma_seq", sequenceName="language_language_id_seq")
	@Column(name="language_id")
	private int id_idioma;
	
	@Column(name="name")
	private String nome;

	public int getId_idioma() {
		return id_idioma;
	}

	public void setId_idioma(int id_idioma) {
		this.id_idioma = id_idioma;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
