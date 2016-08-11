package br.com.mor.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="rental")
public class Aluguel {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aluguel_seq")
	@SequenceGenerator(name="aluguel_seq", sequenceName="rental_rental_id_seq")
	@Column(name="rental_id")
	private int id_aluguel;
	
	@Column(name="rental_date")
	private Date data_aluguel;
	
	@OneToOne
	@JoinColumn(name="inventory_id")
	private Inventario inventario;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Cliente cliente;
	
	@Column(name="return_date")
	private Date data_devolucao;
	
	@ManyToOne
	@JoinColumn(name="staff_id")
	private Equipe equipe;

	public int getId_aluguel() {
		return id_aluguel;
	}

	public void setId_aluguel(int id_aluguel) {
		this.id_aluguel = id_aluguel;
	}

	public Date getData_aluguel() {
		return data_aluguel;
	}

	public void setData_aluguel(Date data_aluguel) {
		this.data_aluguel = data_aluguel;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

}
