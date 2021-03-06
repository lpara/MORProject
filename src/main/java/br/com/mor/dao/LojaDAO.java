package br.com.mor.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import br.com.mor.dominio.Loja;

/**
 * 
 * @author lucas.carvalho | luan.alves
 *
 * @param <T> Tipo do dominio associado ao DAO
 */
public class LojaDAO extends GenericDAO<Loja> {

	public LojaDAO() {
		super(Loja.class);
	}

	/*
	 * Consulta 03 (1,5 Pontos) � Criar uma consulta HQL ou Crit�ria que fornece
	 * o total de vendas (alugueis) da Loja com ID = 1 agrupado por Categoria.
	 * Deve exibir informa��es de 16 Categorias.
	 */
	public List<Object[]> buscarVendasLoja(Integer id) {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			String consulta = "select  loja.id, c.nome, SUM(p.quantia) as total    " + " from Pagamento p "
					+ " join p.aluguel a " + " join a.inventario i " + " join i.filme f " + " join f.categoria c "
					+ " join a.equipe e " + " join e.loja loja " + " group by loja.id, c.nome "
					+ " having loja.id = " + id + " order by c.nome ";

			Query q = session.createQuery(consulta);
			@SuppressWarnings("unchecked")
			List<Object[]> lista = q.getResultList();

			return lista;
		} catch (Exception e) {
			session.getTransaction().rollback();
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
