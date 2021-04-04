package br.com.controle.api.model;

import br.com.controle.api.ennum.StatusPagamento;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pedido.class)
public abstract class Pedido_ {

	public static volatile SingularAttribute<Pedido, StatusPagamento> statusPagamento;
	public static volatile SingularAttribute<Pedido, Cliente> cliente;
	public static volatile ListAttribute<Pedido, ItemPedido> listaItemPedido;
	public static volatile SingularAttribute<Pedido, Float> valorTotal;
	public static volatile SingularAttribute<Pedido, Date> pagamentoAt;
	public static volatile SingularAttribute<Pedido, Long> id;
	public static volatile SingularAttribute<Pedido, Date> createAt;

	public static final String STATUS_PAGAMENTO = "statusPagamento";
	public static final String CLIENTE = "cliente";
	public static final String LISTA_ITEM_PEDIDO = "listaItemPedido";
	public static final String VALOR_TOTAL = "valorTotal";
	public static final String PAGAMENTO_AT = "pagamentoAt";
	public static final String ID = "id";
	public static final String CREATE_AT = "createAt";

}

