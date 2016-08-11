package br.com.mor.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.mor.dominio.Ator;
import br.com.mor.dominio.Filme;

public class GenericService extends GenericDAO<Filme>{

	public GenericService() {
		super(Filme.class);
	}

    public List<Ator> buscarAtoresEFilmes(){
        Session session = getCurrentSession();
        session.getTransaction().begin();
        
        String consulta = "select ator from Ator ator ";
//                + "join ator.filme as filme "
//                + "join filme.categoria as cat "
//                + "order by ator.nome";
        @SuppressWarnings("unchecked")
    Query q = session.createQuery(consulta, Ator.class);
        List<Ator> result = (List<Ator>) q.getResultList(); 
        return result;
        
    }

}
