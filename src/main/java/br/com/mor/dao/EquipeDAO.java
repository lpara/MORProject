package br.com.mor.dao;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.mor.dominio.Equipe;

/**
 * 
 * @author lucas.carvalho | luan.carlos
 *
 * @param <T> Tipo do dominio associado ao DAO
 */
public class EquipeDAO extends GenericDAO<Equipe> {

	public EquipeDAO() {
		super(Equipe.class);
	}

	public Equipe buscarEmpregadoMike(){
		Session session = null;
		try{
	        session = getSessionFactory().openSession();
	        Equipe result = new Equipe();
	        
	        String consulta = "select e from Equipe e "
	                + "inner join e.endereco "
	                + "inner join e.endereco.cidade "
	                + "inner join e.endereco.cidade.pais "
	                + "where e.primeiroNome like :nome and e.ultimoNome like :ultimoNome";
	        
	        Query q = session.createQuery(consulta);
	        q.setParameter("nome", "Mike"); 
	        q.setParameter("ultimoNome", "Hillyer");
	        result = (Equipe) q.getSingleResult();
	        return result;
		}catch(Exception e){
			session.close();
			e.printStackTrace();
		}finally{
			if(session != null && session.isOpen()){
				session.close();
				session = null;
			}
		}
        return null;
    }
}
