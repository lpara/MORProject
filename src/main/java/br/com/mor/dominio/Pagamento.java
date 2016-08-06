package br.com.mor.dominio;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="payment")
public class Pagamento {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pagamento_seq")
	@SequenceGenerator(name="pagamento_seq", sequenceName="payment_payment_id_seq")
	@Column(name="payment_id")
	private int id_pagamento;
	
	@Column(name="customer_id")
	private int id_cliente;
	
	@Column(name="staff_id")
	private int id_equipe;
	
	@Column(name="amount")
	private Number quantia;
	
	@Column(name="payment_date")
	private Date data_pagamento;

	public int getId_pagamento() {
		return id_pagamento;
	}

	public void setId_pagamento(int id_pagamento) {
		this.id_pagamento = id_pagamento;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public int getId_equipe() {
		return id_equipe;
	}

	public void setId_equipe(int id_equipe) {
		this.id_equipe = id_equipe;
	}

	public Number getQuantia() {
		return quantia;
	}

	public void setQuantia(Number quantia) {
		this.quantia = quantia;
	}

	public Date getData_pagamento() {
		return data_pagamento;
	}

	public void setData_pagamento(Date dia_pagamento) {
		this.data_pagamento = dia_pagamento;
	}
}
