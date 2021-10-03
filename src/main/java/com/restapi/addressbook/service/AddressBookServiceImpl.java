package com.restapi.addressbook.service;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restapi.addressbook.dto.AbPostDto;
import com.restapi.addressbook.exception.ResourceNotFoundException;
import com.restapi.addressbook.model.AddressBook;
import com.restapi.addressbook.repository.AddressBookRepository;

@Service
@Transactional
public class AddressBookServiceImpl  implements AddressBookService{

	@Autowired
	AddressBookRepository addressBookRepository;
	
	@Autowired 
	ModelMapper modelMapper;
	
	@Override
	public AbPostDto save(AbPostDto addressBookDto) {
		addressBookRepository.save(mapToEntity(addressBookDto));
		return addressBookDto;
	}
	
	public AbPostDto findAllRecordsById(long id) {

	   return addressBookRepository.findById(id)
			  .map(this :: mapToDto)
			  .orElseThrow(() -> new ResourceNotFoundException("AddressBookId", Long.toString(id)));
		
	}
	

	private AbPostDto mapToDto(AddressBook addressBook) {
		return modelMapper.map(addressBook, AbPostDto.class);
	}

	private AddressBook mapToEntity(AbPostDto addressBookDto) {
	   return modelMapper.map(addressBookDto, AddressBook.class);
	}

}
