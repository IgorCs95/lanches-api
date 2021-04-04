package br.com.controle.api.repository.filter;

public class ItemPedidoFilter {

	private Long pedidoId, clienteId;

	public Long getPedidoId() {
		return pedidoId;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

}
