package br.com.spring.api.projectbrasilprev.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.api.projectbrasilprev.model.Client;
import br.com.spring.api.projectbrasilprev.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

/*-------------------------------------------------------------------------------------------------*/
	public Optional<Client> RegisterClient(Client client) {
		return Optional.of(clientRepository.save(client));
	}
	
	public Optional<Client> UpdateClient(Client client) {
		return Optional.of(clientRepository.save(client));
	}
	
}
