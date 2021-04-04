package br.com.controle.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controle.api.model.ItemPedido;
import br.com.controle.api.repository.itemPedido.ItemPedidoRepositoryQuery;

public interface ItemPedidoRepository  extends JpaRepository<ItemPedido,Long>,ItemPedidoRepositoryQuery{

}
