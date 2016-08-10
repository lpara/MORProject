package br.com.mor.aplication;

import java.util.List;

import org.hibernate.SessionFactory;

import br.com.mor.dao.GenericDAO;
import br.com.mor.dao.SessionFactoryHolder;
import br.com.mor.dominio.Ator;

public class Aplicacao {

	public static void main(String[] args) {
		
		SessionFactory session = SessionFactoryHolder.getSessionFactory();
		GenericDAO<Ator> atorDAO = new GenericDAO<>(Ator.class);
		atorDAO.getCurrentSession();
				
		List<Ator> atores = atorDAO.buscar();
		
		for(Ator ator : atores){
			System.out.println(ator.getPrimeiro_nome());
		}
	}
}
