package br.com.mor.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mor.dominio.Filme;
import br.com.mor.dominio.Inventario;
import br.com.mor.dominio.Loja;
/**
* @author lucas.carvalho | luan.alves
*/
public class InventarioService {

	public List<Inventario> buscarFilmeEmEstoque(int filme){
		InventarioDAO inventDAO = new InventarioDAO();
		
		boolean inventario_in_stock = false;
		List<Loja> lojas = inventDAO.buscarLojasPorFilme(filme);
		List<Inventario> inventarios = new ArrayList<Inventario>();
		List<Inventario> result = new ArrayList<Inventario>();
		
		for(Loja loja : lojas){
			inventarios.addAll(inventDAO.inventariosPorFilmeELoja(filme, loja.getId())); 
		}
		
		for(Inventario i : inventarios){
			inventario_in_stock = inventDAO.isInventarioEmEstoque(i.getId());
			if(inventario_in_stock){
				result.add(i);
			}else{
				continue;
			}
		}
	return result;
	}
}
