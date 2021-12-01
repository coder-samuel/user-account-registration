package org.keeggo.api.brasilprev.repository;

import java.util.List;

import org.keeggo.api.brasilprev.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {	
	public List<Address> findAllByCityContainingIgnoreCase (String city); 

}

