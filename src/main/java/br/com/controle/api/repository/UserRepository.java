package br.com.controle.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.controle.api.model.User;

public interface UserRepository  extends JpaRepository<User,Long>{

}
