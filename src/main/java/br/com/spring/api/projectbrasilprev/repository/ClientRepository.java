package br.com.spring.api.projectbrasilprev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.api.projectbrasilprev.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
	List<Client> findByNameContains( String name);
}
