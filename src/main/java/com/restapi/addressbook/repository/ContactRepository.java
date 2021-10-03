package com.restapi.addressbook.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.restapi.addressbook.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,UUID>{

	Contact findOneByAddressId(UUID uuid);
	
}
