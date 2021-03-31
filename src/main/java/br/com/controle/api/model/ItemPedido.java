package br.com.controle.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="item_pedido",schema = "public")
public class ItemPedido implements Serializable{
	
	@Id
	@ManyToOne
	private Pedido pedido;
	
	@Id
	@OneToOne
	private Produto produto;

	@NotNull
	private float valor;
	private float quantidade;
	
	public ItemPedido() {
		setValor(this.produto.getValor());
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public float getValor() {
		return valor;
	}

	public float getQuantidade() {
		return quantidade;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
		result = prime * result + ((produto == null) ? 0 : produto.hashCode());
		result = prime * result + Float.floatToIntBits(quantidade);
		result = prime * result + Float.floatToIntBits(valor);
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
		ItemPedido other = (ItemPedido) obj;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		if (produto == null) {
			if (other.produto != null)
				return false;
		} else if (!produto.equals(other.produto))
			return false;
		if (Float.floatToIntBits(quantidade) != Float.floatToIntBits(other.quantidade))
			return false;
		if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPedido [pedido=" + pedido + ", produto=" + produto + ", valor=" + valor + ", quantidade="
				+ quantidade + "]";
	}
	
	

}
