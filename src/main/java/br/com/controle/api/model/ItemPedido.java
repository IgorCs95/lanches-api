package br.com.controle.api.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;

@Entity
@Table(name = "item_pedido", schema = "public")
public class ItemPedido{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonBackReference(value = "pedido")
	@ManyToOne
	@JoinColumn(name = "pedido_id", referencedColumnName = "id")
	private Pedido pedido;
	
	@JsonBackReference(value = "produto")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "produto_id", referencedColumnName = "id")
	private Produto produto;
	
	@NotNull
	private Float valor, valorTotal;
	
	@NotNull
	private Float quantidade;
	
	
	public void calcular() {
		System.out.println("//////////////////////////////////////////////////"+produto.getValor());
		
		if(this.valor==null||this.valor==0)
			this.valor = produto.getValor();
		setValorTotal(valor*quantidade);
	}
	
	public Long getId() {
		return id;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public Float getValor() {
		return valor;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	
	
}
