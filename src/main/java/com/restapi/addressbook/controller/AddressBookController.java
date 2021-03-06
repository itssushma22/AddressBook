package com.restapi.addressbook.controller;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.restapi.addressbook.dto.AbPostDto;
import com.restapi.addressbook.service.AddressBookService;


@RestController
@RequestMapping("api/v1/addressBook")
public class AddressBookController {
	

	@Autowired
	AddressBookService  addressBookService;
	

	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	@PostMapping(path="/createBook", consumes="application/json",produces="application/json")
	public AbPostDto createAddressBook(@Valid @RequestBody AbPostDto addressBookDto) {
		
		return addressBookService.save(addressBookDto);
		
	}
	
	
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	@GetMapping(path="/getAll/{addressBookId}")
	public AbPostDto getAllRecordsFromAddressBook(
			@PathVariable long addressBookId
			) {
		
		return  addressBookService.findAllRecordsById(addressBookId);
	}
	


}
