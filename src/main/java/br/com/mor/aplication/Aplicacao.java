package br.com.mor.aplication;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.SessionFactory;


import br.com.mor.dao.AtorDAO;
import br.com.mor.dao.EquipeDAO;
import br.com.mor.dao.SessionFactoryHolder;
import br.com.mor.dominio.Ator;
import br.com.mor.dominio.Categoria;
import br.com.mor.dominio.Equipe;
import br.com.mor.dominio.Filme;

public class Aplicacao {

		public static void main(String[] args) {
	        //Problema 1
			System.out.println("Resultados do Primeiro Problema:");
			problema1();
	        
	        //Problema 2
			System.out.println("Resultados do Segundo Problema");
			problema2();
	        
	    }

		/**
		 * M�todo que execulta a l�gica que soluciona o primeiro problema do trabalho
		 * @author Lucas
		 * @author Luan
		 */
		static void problema1() {
			  @SuppressWarnings("unused")
			SessionFactory session = SessionFactoryHolder.getSessionFactory();
	        AtorDAO  atorDAO = new AtorDAO(Ator.class);
	                
	        List<Ator> atores = atorDAO.buscarAtoresEFilmes();
	        
	        for(Ator ator : atores){
	        	System.out.println("Ator: "+ator.getPrimeiro_nome()+" "+ator.getUltimo_nome());
	            Map<Integer,Filme> filmePorGenero = new HashMap<Integer,Filme>();
	            List<Integer> nomesCategorias = new ArrayList<Integer>();
	        	for(Filme filme : ator.getFilme()){		            
	            
	        		if(filme != null && !filmePorGenero.containsKey(filme.getCategoria().getIdCategoria())){
	        			filmePorGenero.put(filme.getCategoria().getIdCategoria(), filme);
	        			if(!nomesCategorias.isEmpty() && !nomesCategorias.contains(filme.getCategoria().getIdCategoria())){
	        				nomesCategorias.add(filme.getCategoria().getIdCategoria());
	        			}	
	        		}
	        		
	        	}
	        	boolean mudaChave = false;
	        	for(int i : nomesCategorias){
	        		
	        		
	        	/*	if( != null){
	            		System.out.println("**Genero: "+filme.getCategoria().getNome());
	    	        	System.out.println("****");
	            	}*/
	        	}
	            
	           System.out.println("--------------------------------------------------------"); 
	        }
		}
		
		/**
		 * M�todo que execulta a l�gica que soluciona o segundo problema do trabalho
		 * @author Lucas
		 * @author Luan
		 */
		static void problema2() {
			SessionFactory sessionNew = SessionFactoryHolder.getSessionFactory();
	        EquipeDAO  equipeDao = new EquipeDAO();
	                
	        Equipe eq = equipeDao.buscarEmpregadoMike();
	        
	        if(eq != null){
		        System.out.println("--------------------------------------------------------");
	        	System.out.println("Nome: '"+eq.getPrimeiro_nome()+" "+eq.getUltimo_nome()+"'");
	        	System.out.println("Endere�o: '" + eq.getEndereco().getEndereco_principal()+"'");
	        	System.out.println("Telefone: '" + eq.getEndereco().getTelefone()+"'");
	        	System.out.println("Cidade: '" + eq.getEndereco().getCidade().getNome_cidade()+"'");
	        	System.out.println("Pa�s: '" + eq.getEndereco().getCidade().getPais().getNome_pais()+"'");
	        	System.out.println("--------------------------------------------------------");
	        }
	            
		}
}
