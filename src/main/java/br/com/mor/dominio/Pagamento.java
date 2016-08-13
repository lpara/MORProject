package br.com.mor.dominio;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
@Table(name="payment")
public class Pagamento {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pagamento_seq")
	@SequenceGenerator(name="pagamento_seq", sequenceName="payment_payment_id_seq")
	@Column(name="payment_id")
	private int id_pagamento;
	
	@OneToOne
	@JoinColumn(name="customer_id")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name="staff_id")
	private Equipe equipe;
	
	@Column(name="amount")
	private BigDecimal quantia;
	
	@Column(name="payment_date")
	private Timestamp data_pagamento;
	
	@ManyToOne	
	@JoinColumn(name="rental_id")
	private Aluguel aluguel;
	
	public int getId_pagamento() {
		return id_pagamento;
	}

	public void setId_pagamento(int id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
	}

	public Timestamp getData_pagamento() {
		return data_pagamento;
	}

	public BigDecimal getQuantia() {
		return quantia;
	}

	public void setQuantia(BigDecimal quantia) {
		this.quantia = quantia;
	}

	public void setData_pagamento(Timestamp dia_pagamento) {
		this.data_pagamento = dia_pagamento;
	}
	
	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
}
