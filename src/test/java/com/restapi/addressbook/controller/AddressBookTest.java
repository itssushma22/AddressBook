package com.restapi.addressbook.controller;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.restapi.addressbook.dto.AbPostDto;
import com.restapi.addressbook.dto.ContactDto;
import com.restapi.addressbook.service.AddressBookServiceImpl;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;


import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest(controllers = AddressBookController.class)
@ActiveProfiles("test")
@TestInstance(Lifecycle.PER_CLASS)
class AddressBookTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AddressBookServiceImpl addressBookService;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	private AbPostDto  addressBookDto;
	
	private List<ContactDto>  contactDto  = new ArrayList<>();
	
	
	@BeforeAll
	void setup() {
		contactDto = new ArrayList<>();
		contactDto.add(new ContactDto(
		null, "Neil", "Armstrong","4444298000"		
	    ));
	     contactDto.add(new ContactDto(
			null, "Stephen", "Hawking","4144298000"		
		 ));
	   
	    addressBookDto = new AbPostDto(1,"Customer",contactDto);

	}
	
	@Test
    void shouldCreateAdrressBook() throws Exception {
		
		when(addressBookService.save(Mockito.any(AbPostDto.class))).thenReturn(this.addressBookDto);	
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/v1/addressBook/createBook/")
				.accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(addressBookDto))
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
          
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
		assertEquals("application/json",response.getContentType());
		
		 
		 
	               		
	}
	
	@Test
     void shouldGetAllRecords() throws Exception {
		
		 when(addressBookService.findAllRecordsById(Mockito.anyLong())).thenReturn(addressBookDto);
		  
		 RequestBuilder requestBuilder = MockMvcRequestBuilders
					.get("/api/v1/addressBook/getAll/1")
					.accept(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
			MockHttpServletResponse response = result.getResponse();
	          
			assertEquals(HttpStatus.OK.value(), response.getStatus());
			
			String expected = "{\"id\":1,\"name\":\"Customer\",\"contact\":[{\"addressId\":null,\"firstName\":\"Neil\",\"lastName\":\"Armstrong\",\"phoneNumber\":\"4444298000\"},{\"addressId\":null,\"firstName\":\"Stephen\",\"lastName\":\"Hawking\",\"phoneNumber\":\"4144298000\"}]}" ;
			
			JSONAssert.assertEquals(expected, response.getContentAsString(),false);
			
		 
        
	}
	
	
	
	
	
	

}
