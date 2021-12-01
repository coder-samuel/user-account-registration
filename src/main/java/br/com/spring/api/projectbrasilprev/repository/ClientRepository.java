package br.com.spring.api.projectbrasilprev.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.api.projectbrasilprev.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

	public Optional<Client> findByUsername(String username); 
}
