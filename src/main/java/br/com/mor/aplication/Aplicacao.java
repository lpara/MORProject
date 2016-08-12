package br.com.mor.aplication;

import java.util.List;

import org.hibernate.SessionFactory;

import br.com.mor.dao.AtorDAO;
import br.com.mor.dao.EquipeDAO;
import br.com.mor.dao.SessionFactoryHolder;
import br.com.mor.dominio.Ator;
import br.com.mor.dominio.Equipe;
import br.com.mor.dominio.Filme;

public class Aplicacao {

		public static void main(String[] args) {
	        //Problema 1
	        /*@SuppressWarnings("unused")
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
	        }*/
	        
	        //Problema 2
	        SessionFactory sessionNew = SessionFactoryHolder.getSessionFactory();
	        EquipeDAO  equipeDao = new EquipeDAO();
//	        atorDAO.getCurrentSession();
	                
	        Equipe eq = equipeDao.buscarEmpregadoMike();
	        
	        	System.out.println("Nome: '"+eq.getPrimeiro_nome()+" "+eq.getUltimo_nome()+"'");
	        	System.out.println("Endereço: '" + eq.getEndereco().getEndereco_principal()+"'");
	        	System.out.println("Telefone: '" + eq.getEndereco().getTelefone()+"'");
	        	System.out.println("Cidade: '" + eq.getEndereco().getCidade().getNome_cidade()+"'");
	        	System.out.println("País: '" + eq.getEndereco().getCidade().getPais().getNome_pais()+"'");
	        	System.out.println("-----------------------------------------------------");
	           System.out.println("--------------------------------------------------------"); 
	    }

}
