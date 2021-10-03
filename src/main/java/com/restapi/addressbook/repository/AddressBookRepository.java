package com.restapi.addressbook.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.restapi.addressbook.model.AddressBook;


@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Long>{
	
	public List<AddressBook> findAllById(long id);
	public AddressBook findByName(String name);

}
