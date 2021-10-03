package com.restapi.addressbook.service;


import org.springframework.stereotype.Repository;
import com.restapi.addressbook.dto.AbPostDto;

@Repository
public interface AddressBookService {

	AbPostDto save(AbPostDto addressBookDto);
	
	AbPostDto findAllRecordsById(long id);
	
}