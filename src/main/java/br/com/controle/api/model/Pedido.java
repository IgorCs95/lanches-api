package br.com.controle.api.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//@Entity
//@Table(name = "pedido",schema = "public")
public class Pedido {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
//	
//	@ManyToOne
//    @JoinColumn(name = "cliente_id")
	private Cliente cliente;

	private Date createAt;

	private List<Produto> produtos;

	public float valorTotal() {
		return 0;
	}

	public int getId() {
		return id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

}
