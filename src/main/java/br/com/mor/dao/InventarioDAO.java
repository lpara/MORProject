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
	}

	public boolean isInventarioEmEstoque(int iventario){
		List<Aluguel> aluguel1 = new ArrayList<Aluguel>();
		List<Aluguel> aluguel2 = new ArrayList<Aluguel>();
		
		aluguel1 = aluguelExistente(iventario);
		aluguel2 = itemEstaAlugado(iventario);
		if(aluguel1.size() != 0 || aluguel2.size() > 0){
			return false;
		}
		return true;
	}
	
	protected List<Aluguel> aluguelExistente(int inventario){
		
		List<Aluguel> al = new ArrayList<Aluguel>();
		Session session = getCurrentSession();
		session.getTransaction().begin();
		String consulta = "select count(a.id_aluguel) from Aluguel a "
				+ "where a.inventory_id = :id_inventario";
		
		Query q = session.createQuery(consulta);
		q.setParameter("id_inventario", inventario);
		al = q.getResultList();
		session.getTransaction().commit();

		return al;
	}
	
	protected List<Aluguel> itemEstaAlugado (int inventario){
		
		List<Aluguel> al = new ArrayList<Aluguel>();
		Session session = getCurrentSession();
		session.getTransaction().begin();
		String novaConsulta = "select count(a.id_aluguel) from Aluguel a "
				+ "where a.inventory_id = :inventario"
				+ "and a.data_devolucao is null";
		
		Query newQ = session.createQuery(novaConsulta);
		newQ.setParameter("inventario", inventario);
		al = newQ.getResultList();
		session.getTransaction().commit();
		
		return al;
	}
	
	public List<Inventario> inventariosPorFilmeELoja(int idFilme, int idLoja){
		
		Session session = getCurrentSession();
		session.getTransaction().begin();
		String consulta = "select i from Inventario i "
				+ "where i.filme = :filme"
				+ "and i.loja = :loja";
		
		Query q = session.createQuery(consulta);
		q.setParameter("filme", idFilme);
		q.setParameter("loja", idLoja);
		List<Inventario> inventarios = q.getResultList();
		session.getTransaction().commit();
		
		return inventarios;
	}
	
	public List<Inventario> inventariosPorFilme(int filme){
		List<Inventario> invent = new ArrayList<Inventario>();
		
		Session session = getCurrentSession();
		session.getTransaction().begin();
		String consulta = "select i from Inventario i "
				+ "where i.filme = :filme";
		
		Query q = session.createQuery(consulta);
		q.setParameter("filme", filme);
		invent = q.getResultList();
		session.getTransaction().commit();
		
		return invent;
	}
}
