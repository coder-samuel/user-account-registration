package org.keeggo.api.brasilprev.repository;

import java.util.Optional;

import org.keeggo.api.brasilprev.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<UserAccount, Long> {
	public Optional<UserAccount> findByUsername(String username);
}
