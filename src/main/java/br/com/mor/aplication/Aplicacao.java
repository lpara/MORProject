package br.com.mor.aplication;

import java.util.List;

import org.hibernate.SessionFactory;

import br.com.mor.dao.GenericDAO;
import br.com.mor.dao.GenericService;
import br.com.mor.dao.SessionFactoryHolder;
import br.com.mor.dominio.Ator;
import br.com.mor.dominio.Filme;

public class Aplicacao {

		public static void main(String[] args) {
	        
	        SessionFactory session = SessionFactoryHolder.getSessionFactory();
//	        GenericDAO<Ator> atorDAO = new GenericDAO<>(Ator.class);
	        GenericService  atorService = new GenericService();
//	        atorDAO.getCurrentSession();
	                
	        List<Ator> atores = atorService.buscarAtoresEFilmes();
	        
	        for(Ator ator : atores){
	            System.out.println("Ator: "+ ator.getPrimeiro_nome() );
	            /*for(Filme filme : ator.getFilme()){
	                System.out.println(ator.getPrimeiro_nome());
	            }*/
	            
	        }
	    }

}
