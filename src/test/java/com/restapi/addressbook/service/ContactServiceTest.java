package com.restapi.addressbook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import com.restapi.addressbook.dto.AbPostDto;
import com.restapi.addressbook.dto.ContactDto;
import com.restapi.addressbook.model.AddressBook;
import com.restapi.addressbook.model.Contact;
import com.restapi.addressbook.repository.AddressBookRepository;
import com.restapi.addressbook.repository.ContactRepository;



@ExtendWith(MockitoExtension.class)
class ContactServiceTest {

	@Mock
	private ContactRepository contactRepository;

	@Mock
	private AddressBookRepository addressBookRepository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private ContactServiceImpl contactService;
	
	private AbPostDto addressBookDto;
	
	private AddressBook addressBookEntity;

	private ContactDto contactDto;
	
	private Contact contactEntity;

	private List<ContactDto> contactDtoList = new ArrayList<>();
	
	private List<Contact> contactEntityList = new ArrayList<>();

	@BeforeEach
	public void setUp() {

		contactDto = new ContactDto(UUID.fromString("a20c0b79-c639-4fb0-b985-43d913c29a46"), "Neil", "Rock","4444298000");

		contactDtoList.add(contactDto);

		addressBookDto = new AbPostDto(1, "Employee", contactDtoList);
		
		contactEntity =  new Contact(UUID.fromString("a20c0b79-c639-4fb0-b985-43d913c29a46"), "Neil", "Rock","4444298000");

		contactEntityList.add(contactEntity);
		
		addressBookEntity = new AddressBook(1, "Employee", contactEntityList);
		
	}


	@Test
	void shouldSavedContactSuccessFully() {
		final long addressBookId = 1L;
		
		
	         doReturn(contactEntity).when(contactRepository).save(Mockito.any(Contact.class));
	      
	         doReturn(Optional.of(addressBookEntity)).when(addressBookRepository).findById(Mockito.anyLong()) ;
	         
	          when(modelMapper.map(contactDto , Contact.class)).thenReturn(contactEntity);
	        
	          ContactDto savedUser = contactService.save(addressBookId, contactDto);

	          assertThat(savedUser).isNotNull();
	         
	          assertEquals(savedUser, contactDto);

	          verify(contactRepository).save(any(Contact.class));
	

	}
	
	
	@Test
	void shouldGetFindAllDistinctRecords() {
	

        doReturn(contactEntityList).when(contactRepository).findAll();
        when(modelMapper.map( contactEntity, ContactDto.class)).thenReturn(contactDto);
        
        List<ContactDto> expected = contactService.findAllDistinctRecords();

        assertEquals(expected, contactDtoList);

        verify(contactRepository).findAll();
	}
	
	
	@Test
	void shouldDeleteContactRecordSuccessfully() {
		
        doReturn(Optional.of(addressBookEntity)).when(addressBookRepository).findById(Mockito.anyLong()) ;
        
        doReturn(contactEntity).when(contactRepository).findOneByAddressId(any(UUID.class)) ;
        
        when(modelMapper.map(contactEntity , ContactDto.class)).thenReturn(contactDto);
        
        ContactDto expected = contactService.delete(addressBookDto.getId(), contactDto.getAddressId().toString());

        assertEquals(expected, contactDto);

        verify(contactRepository).findOneByAddressId(any(UUID.class));
		
	}

}
