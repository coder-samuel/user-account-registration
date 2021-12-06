package org.keeggo.api.brasilprev.controller;

import java.util.List;

import org.keeggo.api.brasilprev.model.Address;
import org.keeggo.api.brasilprev.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AddressController {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@GetMapping
	public ResponseEntity<List<Address>> GetAll(){
		return ResponseEntity.ok(addressRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Address> GetById(@PathVariable long id){
		return addressRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/city/{city}")
	public ResponseEntity<List<Address>> GetByCity(@PathVariable String city){
		return ResponseEntity.ok(addressRepository.findAllByCityContainingIgnoreCase(city));
	}
	
	@PostMapping
	public ResponseEntity<Address> post (@RequestBody Address address){
		return ResponseEntity.status(HttpStatus.CREATED).body(addressRepository.save(address));
	}
	
	@PutMapping
	public ResponseEntity<Address> put (@RequestBody Address address){
		return ResponseEntity.status(HttpStatus.OK).body(addressRepository.save(address));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		addressRepository.deleteById(id);
	}	
}
