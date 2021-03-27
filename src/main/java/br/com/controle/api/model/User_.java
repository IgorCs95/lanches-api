package br.com.controle.api.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(User.class)
public abstract class User_ {

	public static volatile SingularAttribute<User, String> senha;
	public static volatile SingularAttribute<User, String> nome;
	public static volatile SingularAttribute<User, Long> id;
	public static volatile SingularAttribute<User, String> email;

	public static final String SENHA = "senha";
	public static final String NOME = "nome";
	public static final String ID = "id";
	public static final String EMAIL = "email";

}

