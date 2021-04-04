package br.com.controle.api.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.com.controle.api.ennum.StatusPagamento;

@Entity
@Table(name = "pedido", schema = "public")
public class Pedido {

	@Id
	@SequenceGenerator(name = "pedido_seq", sequenceName = "pedido_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
	private Long id;
	
	@JsonBackReference(value = "cliente")
	@ManyToOne(optional = false)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Cliente cliente;

	@CreatedDate
	@Column(name = "create_at")
	private Date createAt;

	@Column(name = "pagamento_at")
	private Date pagamentoAt;

	@Column(name = "status_pagamento")
	private StatusPagamento statusPagamento;

	@JsonManagedReference(value = "pedido")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_id")
	private List<ItemPedido> listaItemPedido;

	private float valorTotal;
	
	public void calcular() {
		Date dateProvisoria = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		setCreateAt(dateProvisoria);
		setPagamentoAt(dateProvisoria);
		Float valorTotal = 0f;
		for (ItemPedido itemPedido : listaItemPedido) {
			valorTotal+=itemPedido.getValorTotal();
		}
		setValorTotal(valorTotal);
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public Date getPagamentoAt() {
		return pagamentoAt;
	}

	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}

	public List<ItemPedido> getListaItemPedido() {
		return listaItemPedido;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public void setPagamentoAt(Date pagamentoAt) {
		this.pagamentoAt = pagamentoAt;
	}

	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}

	public void setListaItemPedido(List<ItemPedido> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

}
