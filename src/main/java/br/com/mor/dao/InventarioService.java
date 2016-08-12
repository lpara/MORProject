package br.com.mor.dao;

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
	// TODO - Dendências necessárias (DAOs) aqui
	public List<Inventario> buscarFilmeEmEstoque(Integer filme, Integer Loja){
	// TODO - Interações entre os DAOs aqui..
	return Collections .EMPTY_LIST;
	}
}
