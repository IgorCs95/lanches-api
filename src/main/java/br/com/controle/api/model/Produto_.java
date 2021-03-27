package br.com.controle.api.model;

import br.com.controle.api.ennum.Categoria;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Long> estoque;
	public static volatile SingularAttribute<Produto, Categoria> categoria;
	public static volatile SingularAttribute<Produto, Float> valor;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, Long> id;
	public static volatile SingularAttribute<Produto, Boolean> status;

	public static final String ESTOQUE = "estoque";
	public static final String CATEGORIA = "categoria";
	public static final String VALOR = "valor";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

