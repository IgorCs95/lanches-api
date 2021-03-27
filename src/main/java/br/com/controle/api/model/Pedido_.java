package br.com.controle.api.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ {

	public static volatile SingularAttribute<Pedido, Cliente> cliente;
	public static volatile ListAttribute<Pedido, Produto> produtos;
	public static volatile SingularAttribute<Pedido, Integer> id;
	public static volatile SingularAttribute<Pedido, Date> createAt;

	public static final String CLIENTE = "cliente";
	public static final String PRODUTOS = "produtos";
	public static final String ID = "id";
	public static final String CREATE_AT = "createAt";

}

