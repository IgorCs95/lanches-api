package br.com.controle.api.repository.filter;

import java.util.Date;

import br.com.controle.api.ennum.StatusPagamento;

public class PedidoFilter {

	private Long numeroId,clienteId;
	
	private Date dataint,DataFin;
	
	private StatusPagamento statusPagamento;

	public Long getNumeroId() {
		return numeroId;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public Date getDataint() {
		return dataint;
	}

	public Date getDataFin() {
		return DataFin;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public void setNumeroId(Long numeroId) {
		this.numeroId = numeroId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public void setDataint(Date dataint) {
		this.dataint = dataint;
	}

	public void setDataFin(Date dataFin) {
		DataFin = dataFin;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}
	
	
	
	

}
