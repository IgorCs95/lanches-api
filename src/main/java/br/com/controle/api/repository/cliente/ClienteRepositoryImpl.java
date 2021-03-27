package br.com.controle.api.repository.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.controle.api.model.Cliente;
import br.com.controle.api.model.Cliente_;
import br.com.controle.api.repository.filter.ClienteFilter;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cliente> filtrar(ClienteFilter clienteFilter) {

		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
		Root<Cliente> root = criteria.from(Cliente.class);

		Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
		criteria.where(predicates);

		TypedQuery<Cliente> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
		List<Predicate> predicates = new ArrayList<>();

		if (clienteFilter.getId() != null) {
			predicates.add(builder.equal(root.get(Cliente_.id), clienteFilter.getId()));
		}

		if (clienteFilter.getNome() != null) {

			predicates.add(builder.equal(root.get(Cliente_.nome), clienteFilter.getNome()));
		}
		
		

		return predicates.toArray(new Predicate[predicates.size()]);
	}

	

}
