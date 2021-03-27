package br.com.controle.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controle.api.model.Produto;
import br.com.controle.api.repository.produto.ProdutoRepositoryQuery;

public interface ProdutoRepository  extends JpaRepository<Produto,Long>,ProdutoRepositoryQuery{

}
