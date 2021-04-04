package br.com.controle.api.repository.itemPedido;

import java.util.List;

import br.com.controle.api.model.Cliente;
import br.com.controle.api.model.ItemPedido;
import br.com.controle.api.repository.filter.ClienteFilter;
import br.com.controle.api.repository.filter.ItemPedidoFilter;

public interface ItemPedidoRepositoryQuery {
	
	public List<ItemPedido> filtrar(ItemPedidoFilter itemPedidoFilter);

}