package br.com.mor.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.mor.dominio.Ator;

/**
* 
* @author lucas.procopio / luan.alves
*
* @param <T> Tipo do dominio associado ao DAO
*/
public class AtorDAO extends GenericDAO<Ator> {
	
	
    public AtorDAO(Class<Ator> dominio) {
		super(dominio);
	}

	public List<Ator> buscarAtoresEFilmes(){
		
		Session session = getCurrentSession();
		
        session.getTransaction().begin();
        
        String consulta = "select ator from Ator ator ";
        Query q = session.createQuery(consulta, Ator.class);
        @SuppressWarnings("unchecked")
        List<Ator> result = (List<Ator>) q.getResultList();
        session.getTransaction().commit();
        return result;
        
        
    }

}
