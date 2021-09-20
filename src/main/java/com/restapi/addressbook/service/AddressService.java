package com.restapi.addressbook.service;

import java.util.List;

import com.restapi.addressbook.dto.AddressDto;

public interface AddressService {

	AddressDto add(AddressDto addressDto);
	AddressDto delete(AddressDto addressDto);
	List<AddressDto> getRecordsFromAddressBook(String addressbookId);
	List<AddressDto> getAllAddressBookRecords();
}
