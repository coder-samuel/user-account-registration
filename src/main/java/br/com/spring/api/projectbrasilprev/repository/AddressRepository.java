package br.com.spring.api.projectbrasilprev.repository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import br.com.spring.api.projectbrasilprev.model.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>  {

}
