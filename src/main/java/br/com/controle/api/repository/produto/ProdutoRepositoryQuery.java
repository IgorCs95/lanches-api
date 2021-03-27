package br.com.controle.api.repository.produto;

import java.util.List;

import br.com.controle.api.model.Produto;
import br.com.controle.api.repository.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {
	
	public List<Produto> filtrar(ProdutoFilter produtoFilter);

}