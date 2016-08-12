package br.com.mor.dao;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.mor.dominio.Equipe;

public class EquipeDAO extends GenericDAO<Equipe> {

	public EquipeDAO() {
		super(Equipe.class);
	}

	public Equipe buscarEmpregadoMike(){
        Session session = getCurrentSession();
        session.getTransaction().begin();
        Equipe result = new Equipe();
        
        String projecao = "e";
        String consulta = "select "+projecao+" from Equipe e "
                + "inner join e.endereco "
                + "inner join e.endereco.cidade "
                + "inner join e.endereco.cidade.pais "
                + "where e.primeiro_nome like :nome and e.ultimo_nome like :ultimoNome";
        
        Query q = session.createQuery(consulta);
        q.setParameter("nome", "Mike"); 
        q.setParameter("ultimoNome", "Hillyer");
        result = (Equipe) q.getSingleResult();
        session.getTransaction().commit();
        
        if(result != null)
        	return result;
        else
        	return null;
        
        
        
    }
}
