package br.com.mor.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="rental")
public class Aluguel {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="aluguel_seq")
	@SequenceGenerator(name="aluguel_seq", sequenceName="rental_rental_id_seq")
	@Column(name="rental_id")
	private int id_aluguel;
	
	@Column(name="rental_date")
	private Date data_aluguel;
	
	@Column(name="inventory_id")
	private int id_inventario;
	
	@Column(name="customer_id")
	private int id_cliente;
	
	@Column(name="return_date")
	private Date data_devolucao;
	
	@Column(name="staff_id")
	private int id_equipe;

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

	public int getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Date getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}

	public int getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}
}
