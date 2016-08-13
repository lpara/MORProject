package br.com.mor.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.mor.dominio.Aluguel;
import br.com.mor.dominio.Equipe;
import br.com.mor.dominio.Loja;
import br.com.mor.dominio.Pagamento;

/**
* 
* @author lucas.procopio / luan.alves
*
* @param <T> Tipo do dominio associado ao DAO
*/
public class LojaDAO extends GenericDAO<Loja>{

	public LojaDAO(Class<Loja> dominio) {
		super(dominio);
	}

	/*Consulta 03 (1,5 Pontos) – Criar uma consulta HQL ou Critéria que 
	 * fornece o total de vendas (alugueis)  da Loja com ID = 1 agrupado 
	 * por Categoria.  Deve exibir informações de 16 Categorias.
	 */
	public List<Object[]> buscarVendasLoja(Integer id){
		
		Session session = getCurrentSession();
		try {
			

		
		
        session.getTransaction().begin();
        
        String consulta = "select  loja.id_loja, c.nome, SUM(p.quantia) as total    "
        		+ " from Pagamento p "
        		+ " join p.aluguel a "
        		+ " join a.inventario i "
        		+ " join i.filme f "
        		+ " join f.categoria c "
        		+ " join a.equipe e "
        		+ " join e.loja loja "
        		+ " group by loja.id_loja, c.nome "
        		+ " having loja.id_loja = " + id
        		+ " order by c.nome " ;
        		
        Query q = session.createQuery(consulta);
        @SuppressWarnings("unchecked")
        List<Object[]> lista = q.getResultList(); 
     
        session.getTransaction().commit();
        
        return lista;
		} catch (Exception e) {
			session.getTransaction().rollback();
			
			e.printStackTrace();
			System.out.println("");
		}
        
        

        return null;
	}
	
	
}
