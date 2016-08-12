package br.com.mor.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.mor.dominio.Aluguel;
import br.com.mor.dominio.Inventario;

public class InventarioDAO extends GenericDAO<Inventario>{

	public InventarioDAO() {
		super(Inventario.class);
		// TODO Auto-generated constructor stub
	}

	public boolean isInventarioEmEstoque(int iventario){
		List<Aluguel> aluguel = new ArrayList<Aluguel>();
		
		aluguel = aluguelExistente(iventario);
		if(aluguel.size() > 0){
			return false;
		}else{
			aluguel = itemEstaAlugado(iventario);
			if(aluguel.size() > 0){
				return false;
			}
		}
		
		
		return true;
	}
	
	protected List<Aluguel> aluguelExistente(int iventario){
		List<Aluguel> al = new ArrayList<Aluguel>();
		
		Session session = getCurrentSession();
		session.getTransaction().begin();
		String consulta = "select count(a.id_aluguel) from Aluguel a "
				+ "where a.inventory_id = :id_iventario";
		
		Query q = session.createQuery(consulta);
		q.setParameter("id_iventario", iventario);
		
		al = q.getResultList();

		return al;
	}
	
	protected List<Aluguel> itemEstaAlugado (int iventario){
		List<Aluguel> al = new ArrayList<Aluguel>();
		
		Session session = getCurrentSession();
		session.getTransaction().begin();
		String novaConsulta = "select count(a.id_aluguel) from Aluguel a "
				+ "where a.inventory_id = :iventario"
				+ "and a.data_devolucao is null";
		
		Query newQ = session.createQuery(novaConsulta);
		newQ.setParameter("iventario", iventario);
		
		al = newQ.getResultList();
		
		return al;
	}
}
