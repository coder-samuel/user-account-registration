package br.com.spring.api.projectbrasilprev.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.spring.api.projectbrasilprev.model.Client;
import br.com.spring.api.projectbrasilprev.repository.ClientRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public UserDetails loadClientByUsername (String username) throws UsernameNotFoundException {
		Optional<Client> user = clientRepository.finByClient(userName);
		user.orElseThrow(() -> new UsernameNotFoundexception(userName + "not found."));
		
		return user.map(UserDetailsServiceImpl::new).get();
	}

}
