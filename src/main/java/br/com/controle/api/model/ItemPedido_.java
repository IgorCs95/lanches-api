package br.com.controle.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ItemPedido.class)
public abstract class ItemPedido_ {

	public static volatile SingularAttribute<ItemPedido, Produto> produto;
	public static volatile SingularAttribute<ItemPedido, Pedido> pedido;
	public static volatile SingularAttribute<ItemPedido, Float> valor;
	public static volatile SingularAttribute<ItemPedido, Float> quantidade;

	public static final String PRODUTO = "produto";
	public static final String PEDIDO = "pedido";
	public static final String VALOR = "valor";
	public static final String QUANTIDADE = "quantidade";

}

