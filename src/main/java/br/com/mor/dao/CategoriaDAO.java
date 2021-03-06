package br.com.mor.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.mor.dominio.Categoria;

/**
* 
* @author lucas.carvalho | luan.alves
*
* @param <T> Tipo do dominio associado ao DAO
*/
public class CategoriaDAO extends GenericDAO<Categoria> {

	public CategoriaDAO() {
		super(Categoria.class);
	}

	public List<Categoria> buscarCategorias(){
		Session session = null;
		try{
			session = getSessionFactory().openSession();
			String consulta = "select c from Categoria c order by c.nome";
			
			Query q = session.createQuery(consulta);
			List<Categoria> result = q.getResultList();
			
			return result;
		}catch(Exception e){
			session.close();
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()){
				session.close();
				session = null;
			}
		}
		return null;
	}
}
