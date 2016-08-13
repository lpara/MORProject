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
		Integer aluguel1 = 0;
		Integer aluguel2 = 0;
		
		aluguel1 = aluguelExistente(iventario);
		aluguel2 = itemEstaAlugado(iventario);
		if(aluguel1 != 0 || aluguel2 > 0){
			return false;
		}
		return true;
	}
	
	protected Integer aluguelExistente(int inventario){
		
		Session session = getCurrentSession();
		session.getTransaction().begin();
		String consulta = "select count(a.id_aluguel) from Aluguel a "
				+ "where a.inventario.id = :id_inventario";
		
		Query q = session.createQuery(consulta);
		q.setParameter("id_inventario", inventario);
		Long resultado = (Long)q.getSingleResult();
		Integer al = resultado.intValue();
		session.getTransaction().commit();

		return al;
	}
	
	protected Integer itemEstaAlugado (int inventario){
		
		Session session = getCurrentSession();
		session.getTransaction().begin();
		String novaConsulta = "select count(a.id_aluguel) from Aluguel a "
				+ "where a.inventario.id = :inventario "
				+ "and a.data_devolucao is null";
		
		Query newQ = session.createQuery(novaConsulta);
		newQ.setParameter("inventario", inventario);
		Long result = (Long) newQ.getSingleResult();
		Integer al = result.intValue();
		session.getTransaction().commit();
		
		return al;
	}
	
	public List<Inventario> inventariosPorFilmeELoja(int idFilme, int idLoja){
		
		Session session = getCurrentSession();
		session.getTransaction().begin();
		String consulta = "select i from Inventario i "
				+ "where i.filme.id = :filme "
				+ " and i.loja.id = :loja";
		
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
				+ "where i.filme.id = :filme";
		
		Query q = session.createQuery(consulta);
		q.setParameter("filme", filme);
		invent = q.getResultList();
		session.getTransaction().commit();
		
		return invent;
	}
}
