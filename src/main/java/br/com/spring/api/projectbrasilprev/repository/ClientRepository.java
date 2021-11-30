package br.com.spring.api.projectbrasilprev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.api.projectbrasilprev.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	List<Client> findByClient( String client);
}
