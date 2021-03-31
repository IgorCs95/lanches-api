package br.com.controle.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controle.api.model.Pedido;
import br.com.controle.api.repository.pedido.PedidoRepositoryQuery;

public interface PedidoRepository  extends JpaRepository<Pedido,Long>,PedidoRepositoryQuery{

}
