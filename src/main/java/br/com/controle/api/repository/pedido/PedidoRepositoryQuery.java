package br.com.controle.api.repository.pedido;

import java.util.List;

import br.com.controle.api.model.Pedido;
import br.com.controle.api.repository.filter.PedidoFilter;

public interface PedidoRepositoryQuery {
	
	public List<Pedido> filtrar(PedidoFilter pedidoFilter);

}