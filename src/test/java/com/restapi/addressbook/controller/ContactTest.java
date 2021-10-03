package com.restapi.addressbook.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
import com.restapi.addressbook.service.ContactServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(controllers = ContactController.class)
@ActiveProfiles("test")
class ContactTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ContactServiceImpl contactService;
	
	@Autowired
    private ObjectMapper objectMapper;
	
	private AbPostDto  addressBookDto;
	
	private ContactDto contactDto ;
	
	private List<ContactDto> contactList = new ArrayList<>();
	
	
	@BeforeEach
	void setup() {
		
		contactDto= new ContactDto(
	    UUID.fromString("a20c0b79-c639-4fb0-b985-43d913c29a46"), "Neil", "Armstrong","4444298000"		
	    );
		
		contactList.add(contactDto);
		
		contactList.add(new ContactDto(
		UUID.fromString("a20c0b79-c639-4fb0-b985-43d913c29a46"), "Sushma", "Rathore","4444298000"		
	    ));
		
		addressBookDto  = new AbPostDto(1,"Employee" ,contactList);
	}
	
	@Test
	void shouldCreateContact() throws Exception {
		
	     	ContactDto contact =  new ContactDto(
				null, "David", "Parker","4449298000" );
	
		
		when(contactService.save(Mockito.anyLong(), Mockito.any(ContactDto.class))).thenReturn(contact);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/v1/contact/addressBook/1/")
				.accept(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(contact))
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
          
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
		assertEquals("application/json",response.getContentType());
		           		
	}
	
	@Test
	void shouldGetAllDistinctRecords() throws Exception {
		 
		   when(contactService.findAllDistinctRecords()).thenReturn(addressBookDto.getContact());
		
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.get("/api/v1/contact/getAllDistinctRecords/")
					.accept(MediaType.APPLICATION_JSON);
					
			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
			MockHttpServletResponse response = result.getResponse();
			
            assertEquals(HttpStatus.OK.value(), response.getStatus());
        
            String expected = "[{\"addressId\":\"a20c0b79-c639-4fb0-b985-43d913c29a46\",\"firstName\":\"Neil\",\"lastName\":\"Armstrong\",\"phoneNumber\":\"4444298000\"},{\"addressId\":\"a20c0b79-c639-4fb0-b985-43d913c29a46\",\"firstName\":\"Sushma\",\"lastName\":\"Rathore\",\"phoneNumber\":\"4444298000\"}]";
			JSONAssert.assertEquals(expected, response.getContentAsString(), false); 
			 
	}
	
	
	@Test
	void shouldDeleteUser() throws Exception {
		 final UUID contactId = UUID.fromString("e3b75708-d66f-4666-bde4-969bc34358a9");
		 
		 ContactDto contact =  new ContactDto(
				 contactId, "David", "Parker","4449298000" );
		
		 
		   when(contactService.delete(Mockito.anyLong(), Mockito.anyString())).thenReturn(contact);
		   
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.delete("/api/v1/contact/addressBook/1/addressId/e3b75708-d66f-4666-bde4-969bc34358a9")
					.accept(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			
			MockHttpServletResponse response = result.getResponse();
	          
			assertEquals(HttpStatus.OK.value(), response.getStatus());
			
			assertEquals("application/json",response.getContentType());
			
			String expected = "{\"addressId\":\"e3b75708-d66f-4666-bde4-969bc34358a9\",\"firstName\":\"David\",\"lastName\":\"Parker\",\"phoneNumber\":\"4449298000\"}";
			
			JSONAssert.assertEquals(expected, response.getContentAsString(), false); 
        
	}
	
	
	
	
	

}
