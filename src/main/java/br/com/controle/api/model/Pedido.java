package br.com.controle.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

import br.com.controle.api.ennum.StatusPagamento;

@Entity
@Table(name = "pedido", schema = "public")
public class Pedido {

	@Id
	@SequenceGenerator(name = "pedido_seq", sequenceName = "pedido_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido_seq")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@CreatedDate
	private Date createAt;

	private Date pagamentoAt;

	private StatusPagamento statusPagamento;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ItemPedido> listaItemPedido;

	public float valorTotal() {
		return 0;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((createAt == null) ? 0 : createAt.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((listaItemPedido == null) ? 0 : listaItemPedido.hashCode());
		result = prime * result + ((pagamentoAt == null) ? 0 : pagamentoAt.hashCode());
		result = prime * result + ((statusPagamento == null) ? 0 : statusPagamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (createAt == null) {
			if (other.createAt != null)
				return false;
		} else if (!createAt.equals(other.createAt))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listaItemPedido == null) {
			if (other.listaItemPedido != null)
				return false;
		} else if (!listaItemPedido.equals(other.listaItemPedido))
			return false;
		if (pagamentoAt == null) {
			if (other.pagamentoAt != null)
				return false;
		} else if (!pagamentoAt.equals(other.pagamentoAt))
			return false;
		if (statusPagamento != other.statusPagamento)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", cliente=" + cliente + ", createAt=" + createAt + ", pagamentoAt=" + pagamentoAt
				+ ", statusPagamento=" + statusPagamento + ", listaItemPedido=" + listaItemPedido + "]";
	}

}
