package br.com.mor.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mor.dominio.Filme;
import br.com.mor.dominio.Inventario;
/**
* @author lucas.carvalho | luan.alves
*/
public class InventarioService {

	public List<Inventario> buscarFilmeEmEstoque(int filme, int loja){
		InventarioDAO inventDAO = new InventarioDAO();
		boolean inventario_in_stock = false;
		List<Inventario> temp = inventDAO.inventariosPorFilmeELoja(filme, loja);
		List<Inventario> result = new ArrayList<Inventario>();
		
		for(Inventario i : temp){
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
