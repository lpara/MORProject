package br.com.mor.dao;

import java.util.List;

import org.hibernate.Session;

import br.com.mor.dominio.Filme;

public class AtorFilmeService extends GenericDAO<Filme>{

	public AtorFilmeService() {
		super(Filme.class);
	}

	List<Filme> buscarAtoresEFilmes(){
		Session session = getCurrentSession();
		
		String consulta = "select filme from Filme filme "
				+ "join filme.ator as ator "
				+ "join filme.categoria as cat "
				+ "order by cat.nome";
		List<Filme> result = (List<Filme>) session.createQuery(consulta, Filme.class);
		
		return result;
		
	}
}
