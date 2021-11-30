package br.com.spring.api.projectbrasilprev.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.spring.api.projectbrasilprev.model.Client;
import br.com.spring.api.projectbrasilprev.repository.AddressRepository;
import br.com.spring.api.projectbrasilprev.repository.ClientRepository;
import br.com.spring.api.projectbrasilprev.service.ClientService;

@Controller
@RequestMapping
@CrossOrigin("*")
public class ClientController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientService clientService;
	
/*---------------------------------------------------------------------------------------------------------------*/
	
	@GetMapping("/login")
	public String Login() {
		return "login";
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Client> GetById (@PathVariable long id) {
		return clientRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping("/register")
	public ResponseEntity<Client> post(@RequestBody Client client) {
		Optional<Client> user = clientService.RegisterClient(client);
		try {
			return ResponseEntity.ok(user.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/register")
	public ResponseEntity<Client> put(@RequestBody Client client){
		return ResponseEntity.status(HttpStatus.OK).body(clientService.UpdateClient(client));
	}
	

}
