package com.restapi.addressbook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.addressbook.dto.AddressDto;
import com.restapi.addressbook.repository.AddressRepository;

@Service
public class AddressServiceImpl  implements AddressService{

	@Autowired
	AddressRepository addressRepository;
	
	@Override
	public AddressDto add(AddressDto addressDto) {
		// TODO Auto-generated method stub
		
		addressRepository.save(addressDto);
		return addressDto;
	}

	@Override
	public AddressDto delete(AddressDto addressDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressDto> getRecordsFromAddressBook(String addressbookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AddressDto> getAllAddressBookRecords() {
		// TODO Auto-generated method stub
		return null;
	}



}
