package org.keeggo.api.brasilprev.controller;

import java.util.List;
import java.util.Optional;

import org.keeggo.api.brasilprev.model.UserAccount;
import org.keeggo.api.brasilprev.model.UserLogin;
import org.keeggo.api.brasilprev.repository.UserRepository;
import org.keeggo.api.brasilprev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@CrossOrigin("*")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<UserAccount>> GetAll() {
		return ResponseEntity.ok(userRepository.findAll());
	}

	@PostMapping("/login")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user) {
		return userService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/register")
	public ResponseEntity<UserAccount> Post(@RequestBody UserAccount userAccount) {
		Optional<UserAccount> user = userService.CadastrarUsuario(userAccount);
		try {
				return ResponseEntity.ok(user.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		
	}

}
