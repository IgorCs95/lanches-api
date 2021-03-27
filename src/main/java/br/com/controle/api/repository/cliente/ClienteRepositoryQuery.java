package br.com.controle.api.repository.cliente;

import java.util.List;

import br.com.controle.api.model.Cliente;
import br.com.controle.api.repository.filter.ClienteFilter;

public interface ClienteRepositoryQuery {
	
	public List<Cliente> filtrar(ClienteFilter clienteFilter);

}