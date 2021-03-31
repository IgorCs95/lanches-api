package br.com.controle.api.repository.pedido;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.controle.api.model.Pedido;
import br.com.controle.api.model.Pedido_;
import br.com.controle.api.repository.filter.PedidoFilter;

public class PedidoRepositoryImpl implements PedidoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Pedido> filtrar(PedidoFilter pedidoFilter) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Pedido> criteria = builder.createQuery(Pedido.class);
		Root<Pedido> root = criteria.from(Pedido.class);

		Predicate[] predicates = criarRestricoes(pedidoFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Pedido> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(PedidoFilter pedidoFilter, CriteriaBuilder builder, Root<Pedido> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (pedidoFilter.getNumeroId() != null) {
			predicates.add(builder.equal(root.get(Pedido_.id), pedidoFilter.getNumeroId()));
		}

		if (pedidoFilter.getClienteId() != null) {

			predicates.add(builder.equal(root.get(Pedido_.cliente), pedidoFilter.getClienteId()));
		}
		
		if (pedidoFilter.getDataint() != null) {

			predicates.add(builder.equal(root.get(Pedido_.createAt), pedidoFilter.getDataint()));
		}
		
		if (pedidoFilter.getDataFin() != null) {

			predicates.add(builder.equal(root.get(Pedido_.createAt), pedidoFilter.getDataFin()));
		}
		
		

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	

}
