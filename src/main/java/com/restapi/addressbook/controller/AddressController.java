package com.restapi.addressbook.controller;


import java.text.ParseException;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.addressbook.dto.AddressDto;
import com.restapi.addressbook.model.Address;
import com.restapi.addressbook.service.AddressService;

@RestController
@RequestMapping("api/v1/addressBook")
public class AddressController {
	
	@Autowired
	private AddressService addressService ;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@PostMapping(path="/addContact", consumes="application/json" , produces ="application/json")
	public AddressDto AddContactToAddressBook(
			@RequestBody AddressDto addressDto ){
		
		AddressDto addressDtoCreated =	this.addressService.add(addressDto);
		
		return  addressDtoCreated;
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@DeleteMapping(path="/", consumes="application/json" , produces ="application/json")
	public AddressDto deleteContactFromAdressBook(
			@PathVariable String addressBookId,
			@PathVariable String addressId
			) {
		
		
		
		return null;	
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@GetMapping(path="/", consumes="application/json" , produces ="application/json")
	public List<AddressDto> getRecordsFromAddressBook(
			@PathVariable String addressBookId
			) {
		
		
		
		return null;	
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@GetMapping(path="/", consumes="application/json" , produces ="application/json")
	public List<AddressDto> getAllAddressBookRecords() {
		
		return null;	
	}
	
	
	private AddressDto convertToDto(Address address) {
		AddressDto addressDto = modelMapper.map(address, AddressDto.class);
	    return addressDto;
	}
	
	
	private Address convertToEntity(AddressDto addressDto) throws ParseException {
		Address address = modelMapper.map(addressDto, Address.class);
	    return address;
	}
	

}
