package br.com.controle.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Cliente.class)
public abstract class Cliente_ {

	public static volatile SingularAttribute<Cliente, Long> telefone;
	public static volatile SingularAttribute<Cliente, String> nome;
	public static volatile SingularAttribute<Cliente, Long> id;
	public static volatile SingularAttribute<Cliente, Integer> limite;
	public static volatile ListAttribute<Cliente, Pedido> listPedidos;

	public static final String TELEFONE = "telefone";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String LIMITE = "limite";
	public static final String LIST_PEDIDOS = "listPedidos";

}

