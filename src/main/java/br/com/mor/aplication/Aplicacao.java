package br.com.mor.aplication;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import org.hibernate.SessionFactory;


import br.com.mor.dao.AtorDAO;
import br.com.mor.dao.CategoriaDAO;
import br.com.mor.dao.EquipeDAO;
import br.com.mor.dao.InventarioService;
import br.com.mor.dao.LojaDAO;
import br.com.mor.dao.SessionFactoryHolder;
import br.com.mor.dominio.Ator;
import br.com.mor.dominio.Categoria;
import br.com.mor.dominio.Equipe;
import br.com.mor.dominio.Filme;
import br.com.mor.dominio.Inventario;
import br.com.mor.dominio.Loja;
/**
* @author lucas.carvalho | luan.alves
*/
public class Aplicacao {

		public static void main(String[] args) {
	        //Problema 1
			System.out.println("Resultados do Primeiro Problema:");
			problema1();
	        
	        //Problema 2
			System.out.println("Resultados do Segundo Problema:");
			problema2();
			
	        //Problema 3
			System.out.println("Resultados do Tereceiro Problema:");
			problema3();
			
			//Operação de Negócio
			System.out.println("Resultados da Operação de Negocio:");
			operacaoNegocio();
	        
	    }

		/**
		 * Método que execulta a lógica que soluciona o primeiro problema do trabalho
		 * @author Lucas
		 * @author Luan
		 */
		static void problema1() {
	        AtorDAO  atorDAO = new AtorDAO();
	        CategoriaDAO catDAO = new CategoriaDAO();
	        
	        List<Ator> atores = atorDAO.buscarAtoresEFilmes();
	        List<Categoria> categorias = catDAO.buscarCategorias();
	        boolean catJaImpressa = false;
	        String filmesDaCategoria = "**** ";
	        
	        for(Ator ator : atores){
	        	System.out.println("Ator: "+ator.getPrimeiroNome()+" "+ator.getUltimoNome());
	        	for(Categoria categoria : categorias){		            
	        		for(Filme filme : ator.getFilme()){
	        			if(filme.getCategoria().getId() == categoria.getId() && !catJaImpressa){
	        				System.out.println("**Genero: "+categoria.getNome());
	    	        		filmesDaCategoria = filmesDaCategoria+filme.getTitulo()+", ";
	    	        		catJaImpressa = true;
	        			}else if(filme.getCategoria().getId() == categoria.getId() && catJaImpressa){
	        				filmesDaCategoria = filmesDaCategoria+filme.getTitulo()+", ";
	        			}else{
	        				continue;
	        			}
	        		}
	        		if(catJaImpressa){
	        			filmesDaCategoria = filmesDaCategoria.substring(0, filmesDaCategoria.length()-2);
	        			System.out.println(filmesDaCategoria);
	        		}
	        		filmesDaCategoria = "**** ";
        			catJaImpressa = false;
	        	} 
	           System.out.println("--------------------------------------------------------"); 
	        }
		}
		
		/**
		 * Método que execulta a lógica que soluciona o segundo problema do trabalho
		 * @author Lucas
		 * @author Luan
		 */
		static void problema2() {
	        EquipeDAO  equipeDao = new EquipeDAO();          
	        Equipe eq = equipeDao.buscarEmpregadoMike();
	        
	        if(eq != null){
		        System.out.println("--------------------------------------------------------");
	        	System.out.println("Nome: '"+eq.getPrimeiroNome()+" "+eq.getUltimoNome()+"'");
	        	System.out.println("Endereço: '" + eq.getEndereco().getEnderecoPrincipal()+"'");
	        	System.out.println("Telefone: '" + eq.getEndereco().getTelefone()+"'");
	        	System.out.println("Cidade: '" + eq.getEndereco().getCidade().getNome_cidade()+"'");
	        	System.out.println("País: '" + eq.getEndereco().getCidade().getPais().getNome()+"'");
	        	System.out.println("--------------------------------------------------------");
	        }
	            
		}
		
		/**
		 * Método que execulta a lógica que soluciona o terceiro problema do trabalho
		 * @author Lucas
		 * @author Luan
		 */
		public static void problema3(){
	        LojaDAO  lojaDAO = new LojaDAO();
            
	        List<Object[]> totalCategoria = lojaDAO.buscarVendasLoja(1);
	        
	        for(Object[] obj : totalCategoria){
	        	System.out.println("Categoria: "+ obj[1] + " Total = " + obj[2]);
	        	System.out.println("-----------------------------------------------------");
	        }
		}
		
		/**
		 * Método que execulta a lógica que soluciona a operação de negócio.
		 * @author Lucas
		 * @author Luan
		 */
		static void operacaoNegocio(){
			InventarioService inventServ = new InventarioService();
			List<Inventario> result = new ArrayList<Inventario>();
			
			result = inventServ.buscarFilmeEmEstoque(1);
			for(Inventario inventUm : result){
				System.out.println("ID Inventário: "+ inventUm.getId()+"; Loja: "+inventUm.getLoja().getId());;
			}
		}
}
