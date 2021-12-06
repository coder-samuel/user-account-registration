package org.keeggo.api.brasilprev.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.keeggo.api.brasilprev.model.UserAccount;
import org.keeggo.api.brasilprev.model.UserLogin;
import org.keeggo.api.brasilprev.repository.UserRepository;
import org.keeggo.api.brasilprev.request.NewUserRequest;
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

import static java.lang.String.format;

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
		return userService.Login(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/users")
    ResponseEntity<Void> newUserAccount(@RequestBody @Valid NewUserRequest newUserRequest) {
        userRepository.save(newUserRequest.toEntity());
        URI location = URI.create(format("/users/%s", newUserRequest.getUsername()));
        return ResponseEntity.created(location).build();
    }
}
