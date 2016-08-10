package br.com.mor.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Lucas 
 * @author Luan 
 *
 * @param <T> - Entidade Persistente
 * @param <ID> - Chave Primaria
 */
public interface DAO <T, ID extends Serializable> {

	T salvar(T entidade);
	
	void deletar(T entidade);
	
	long contar();

	List<T> buscar();
	
	List<T> buscar(int offset, int max);
	
}