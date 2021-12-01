package br.com.spring.api.projectbrasilprev.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.spring.api.projectbrasilprev.model.Client;
import br.com.spring.api.projectbrasilprev.repository.ClientRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private ClientRepository clientRepository;

	@Override
	public UserDetails loadUserByUsername(String userame) throws UsernameNotFoundException {
		Optional<Client> client = clientRepository.findByUsername(userName);
		client.orElseThrow(() -> new UsernameNotFoundException(userName + " not found."));

		return client.map(UserDetailsImpl::new).get();
	}
}