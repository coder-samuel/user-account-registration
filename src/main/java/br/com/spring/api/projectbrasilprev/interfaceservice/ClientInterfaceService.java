package br.com.spring.api.projectbrasilprev.interfaceservice;

import java.util.List;
import java.util.Optional;

import br.com.spring.api.projectbrasilprev.model.Client;

public interface ClientInterfaceService {
	public List<Client> finAll();
	public Optional<Client> findById (Integer cpf);
}
