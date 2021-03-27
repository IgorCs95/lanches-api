package br.com.controle.api.repository.filter;

import br.com.controle.api.ennum.Categoria;

public class ProdutoFilter {

	private Long id;

	private String nome;

	private Categoria categoria;
	
	private boolean status;
	

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
