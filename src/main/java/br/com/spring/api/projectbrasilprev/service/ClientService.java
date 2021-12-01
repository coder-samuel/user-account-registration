package br.com.spring.api.projectbrasilprev.service;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.spring.api.projectbrasilprev.model.Client;
import br.com.spring.api.projectbrasilprev.model.UserLogin;
import br.com.spring.api.projectbrasilprev.repository.ClientRepository;

public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public Optional<Client> RegisterClient(Client client) {

		if (clientRepository.findByUsername(client.getUsername()).isPresent())
			return null;

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String passwordEncoder = encoder.encode(client.getPassword());
		client.setPassword(passwordEncoder);

		return Optional.of(clientRepository.save(client));
	}
	
	public Optional<Client> UpdateClient (Client client) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String passwordEncoder = encoder.encode(client.getPassword());
		client.setPassword(passwordEncoder);

		return Optional.of(clientRepository.save(client));
	}

	public Client AtualizarUsuario(Client client) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String passwordEncoder = encoder.encode(client.getPassword());
		client.setPassword(passwordEncoder);

		return (clientRepository.save(client));
	}
	
	public Optional<UserLogin> Login(Optional<UserLogin> user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<Client> client = clientRepository.findByUsername(user.get().getUsername());

		if (client.isPresent()) {
			if (encoder.matches(client.get().getPassword(), client.get().getPassword())) {

				String auth = user.get().getUsername() + ":" + user.get().getPassword();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setId(client.get().getId());
				user.get().setUsername(client.get().getUsername());
				user.get().setEmail(client.get().getEmail());
				user.get().setPassword(client.get().getPassword());
				
				return user;
			}
		}
		return null;
	}
}