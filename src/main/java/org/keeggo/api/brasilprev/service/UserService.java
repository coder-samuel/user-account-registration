package org.keeggo.api.brasilprev.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.keeggo.api.brasilprev.model.UserAccount;
import org.keeggo.api.brasilprev.model.UserLogin;
import org.keeggo.api.brasilprev.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Optional<UserAccount> CadastrarUsuario(UserAccount userAccount) {
		
		
		if(userRepository.findByUsername(userAccount.getUsername()).isPresent())
			return null;
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		String senhaEncoder = encoder.encode(userAccount.getPassword());
		userAccount.setPassword(senhaEncoder);

		return Optional.of(userRepository.save(userAccount));
	}

	public Optional<UserLogin> Logar(Optional<UserLogin> user) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UserAccount> userAccount = userRepository.findByUsername(user.get().getUsername());

		if (userAccount.isPresent()) {
			if (encoder.matches(user.get().getPassword(), userAccount.get().getPassword())) {

				String auth = user.get().getUsername() + ":" + user.get().getPassword();
				byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encodedAuth);

				user.get().setId(userAccount.get().getId());
				user.get().setUsername(userAccount.get().getUsername());
				user.get().setPassword(userAccount.get().getPassword());
				user.get().setEmail(userAccount.get().getEmail());

				return user;

			}
		}
		return null;
	}

}
