package com.restapi.addressbook.service;


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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class AddressBookServiceTest {

	    @Mock
	    private AddressBookRepository addressBookRepository;
	    
	    @Mock
	    private ModelMapper modelMapper ;

	    @InjectMocks
	    private AddressBookServiceImpl addressBookService;
	    

	    private AbPostDto addressBookDto = new AbPostDto();
        private AddressBook addressBook = new AddressBook();
        private  List<ContactDto> contactDtoList = new ArrayList<>();
        private  List<Contact> contactEntityList = new ArrayList<>();
        
        
        @BeforeEach
        public void setUp() {
        	 
        	contactDtoList.add(new ContactDto(
 	    			null, "Neil", "Armstrong","4444298000"		
 	    		   ));
            
        	contactEntityList.add(new Contact( "Neil", "Armstrong","4444298000"));
        
	         
        	 addressBookDto = new AbPostDto(
	    			1L, "CustomerAddresssBook", contactDtoList
	           );
        	
        	 addressBook = new AddressBook(
 	    			1L, "CustomerAddresssBook", contactEntityList
 	          );
         	
	    }
        
        
		
	    @Test
	    void shouldSavedUserSuccessFully() {
	         
	        doReturn(addressBook).when(addressBookRepository).save(Mockito.any(AddressBook.class));
	        when(modelMapper.map(addressBookDto , AddressBook.class)).thenReturn(addressBook);
	        
	        AbPostDto savedUser = addressBookService.save(addressBookDto);

	        assertThat(savedUser).isNotNull();
	        
	        assertEquals(savedUser, addressBookDto);

	        verify(addressBookRepository).save(any(AddressBook.class));
	     

	    }

	    @Test
	    void shouldReturnFindAllContactsByAddressBookId() {
	 
	    	long addressBookId = 1L ;

	        doReturn(Optional.of(addressBook)).when(addressBookRepository).findById(Mockito.anyLong());
	        when(modelMapper.map( addressBook, AbPostDto.class)).thenReturn(addressBookDto);
	        
	        AbPostDto expected = addressBookService.findAllRecordsById(addressBookDto.getId());

	        assertEquals(expected, addressBookDto);

	        verify(addressBookRepository).findById(addressBookId);
	     
	    }

}
