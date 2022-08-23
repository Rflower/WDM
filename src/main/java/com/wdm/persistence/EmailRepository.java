package com.wdm.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.wdm.domain.AuthEmail;

public interface EmailRepository extends CrudRepository<AuthEmail, String> {

	@Query(value = "SELECT auth_key FROM auth_email WHERE email=?1", nativeQuery = true)
	String findkey(String email);
	
}
