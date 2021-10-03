package com.restapi.addressbook.controller;


import java.util.List;
import javax.validation.Valid;
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
import com.restapi.addressbook.dto.ContactDto;
import com.restapi.addressbook.service.ContactService;

@RestController
@RequestMapping("api/v1/contact/")
public class ContactController {
	
	@Autowired
	private ContactService contactService ;
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@PostMapping(path="/addressBook/{addressBookId}", consumes="application/json" , produces ="application/json")
	public ContactDto addContactToAddressBook(
			@PathVariable long addressBookId,
			@Valid @RequestBody ContactDto addressDto ){
		
		return  this.contactService.save(addressBookId, addressDto);
	}
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@DeleteMapping(path="/addressBook/{addressBookId}/addressId/{addressId}")
	public ContactDto deleteContactFromAdressBook(
			@PathVariable long addressBookId,
			@PathVariable String addressId
			) {
		
		return  this.contactService.delete(addressBookId, addressId);	
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@GetMapping(path="/getAllDistinctRecords")
	public List<ContactDto> getAllDistinctRecords() {
		
		return  this.contactService.findAllDistinctRecords();
	}
	
	
}
