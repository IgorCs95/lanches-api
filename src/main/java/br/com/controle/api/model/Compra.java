package br.com.controle.api.model;

import java.util.Date;

public class Compra {

	private int id;

	private Date createAt;

	private int valor;

	private Produto produto;

	public int getId() {
		return id;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public int getValor() {
		return valor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	

}
