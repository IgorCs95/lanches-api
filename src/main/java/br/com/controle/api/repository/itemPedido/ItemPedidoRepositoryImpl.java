package br.com.controle.api.repository.itemPedido;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.controle.api.model.ItemPedido;
import br.com.controle.api.model.ItemPedido_;
import br.com.controle.api.repository.filter.ItemPedidoFilter;

public class ItemPedidoRepositoryImpl implements ItemPedidoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<ItemPedido> filtrar(ItemPedidoFilter itemPedidoFilter) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<ItemPedido> criteria = builder.createQuery(ItemPedido.class);
		Root<ItemPedido> root = criteria.from(ItemPedido.class);

		Predicate[] predicates = criarRestricoes(itemPedidoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<ItemPedido> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ItemPedidoFilter itemPedidoFilter, CriteriaBuilder builder, Root<ItemPedido> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (itemPedidoFilter.getPedidoId() != null) {
			predicates.add(builder.equal(root.get(ItemPedido_.pedido), itemPedidoFilter.getClienteId()));
		}

		if (itemPedidoFilter.getClienteId() != null) {

			predicates.add(builder.equal(root.get(ItemPedido_.produto), itemPedidoFilter.getClienteId()));
		}
		
		
		

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	

}
