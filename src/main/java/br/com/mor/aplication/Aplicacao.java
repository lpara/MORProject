package br.com.mor.aplication;

import java.util.List;

import org.hibernate.SessionFactory;

import br.com.mor.dao.AtorDAO;
import br.com.mor.dao.SessionFactoryHolder;
import br.com.mor.dominio.Ator;
import br.com.mor.dominio.Filme;

public class Aplicacao {

		public static void main(String[] args) {
	        
	        @SuppressWarnings("unused")
			SessionFactory session = SessionFactoryHolder.getSessionFactory();
	        AtorDAO  atorDAO = new AtorDAO(Ator.class);
	                
	        List<Ator> atores = atorDAO.buscarAtoresEFilmes();
	        
	        for(Ator ator : atores){
	        	System.out.println("Ator: "+ ator.getPrimeiro_nome());
	        	System.out.println("Filmes: " );
	        	System.out.println("-----------------------------------------------------");
	            for(Filme filme : ator.getFilme()){		            
	            	if(filme != null){
	            		System.out.println(filme.getTitulo());
	            		System.out.println("Categoria: " + filme.getCategoria().getNome());
	            	}
	            	
	            }
	           System.out.println("--------------------------------------------------------"); 
	        }
	    }

}
