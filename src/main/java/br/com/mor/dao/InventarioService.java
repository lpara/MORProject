package br.com.mor.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.mor.dominio.Filme;
import br.com.mor.dominio.Inventario;

public class InventarioService {

	
	/*SELECT inventory_id
     FROM inventory
     WHERE film_id = $1
     AND store_id = $2
     AND inventory_in_stock(inventory_id); */
	public List<Inventario> buscarFilmeEmEstoque(int filme, int loja){
		InventarioDAO inventDAO = new InventarioDAO();
		boolean inventario_in_stock = false;
		List<Inventario> temp = inventDAO.inventariosPorFilmeELoja(filme, loja);
		List<Inventario> result = new ArrayList<Inventario>();
		
		for(Inventario i : temp){
			inventario_in_stock = inventDAO.isInventarioEmEstoque(i.getId_inventario());
			if(inventario_in_stock){
				result.add(i);
			}else{
				continue;
			}
		}
	return result;
	}
}
