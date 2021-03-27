package br.com.controle.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controle.api.model.Cliente;
import br.com.controle.api.repository.cliente.ClienteRepositoryQuery;

public interface ClienteRepository  extends JpaRepository<Cliente,Long>,ClienteRepositoryQuery{

}
