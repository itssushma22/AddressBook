package com.restapi.addressbook.service;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restapi.addressbook.dto.ContactDto;
import com.restapi.addressbook.exception.ResourceNotFoundException;
import com.restapi.addressbook.model.AddressBook;
import com.restapi.addressbook.model.Contact;
import com.restapi.addressbook.repository.AddressBookRepository;
import com.restapi.addressbook.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
    AddressBookRepository addressBookRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ContactDto save(long addressBookId, ContactDto contactDto)  {
		
		return addressBookRepository.findById(addressBookId).map(addressBook ->{
			
			Contact contact = this.mapToEntity(contactDto);
			
			contact.setAddressBook(addressBook);
			
			contactRepository.save(contact);
			
			return contactDto;
			
		}).orElseThrow(() -> new ResourceNotFoundException("AddressBookId", Long.toString(addressBookId)));


	}

	@Override
	public ContactDto delete(long addressBookId, String contactId) {

		Optional<AddressBook> addressBook = addressBookRepository.findById(addressBookId);
		
		if(addressBook.isPresent()) {
			
			Optional<Contact> contact =  Optional.of(this.contactRepository.findOneByAddressId(UUID.fromString(contactId))) ;
			
			if(contact.isPresent()) {
				this.contactRepository.delete(contact.get());
				return mapToDto(contact.get()); 
			} else {
				throw new ResourceNotFoundException("contactId",contactId);
			}
			
		} else {
			throw new ResourceNotFoundException("AddressBookId", Long.toString(addressBookId));
		}
	}


	@Override
	public List<ContactDto> findAllDistinctRecords() {

		List<Contact> allRecords = this.contactRepository.findAll();

		return
			allRecords.stream().
			map(item -> this.mapToDto(item))
			.filter(distinctByKey(p -> p.getPhoneNumber()))
				.collect(Collectors.toList());

	}
	
	@Override
	public ContactDto findOneByAddressId(String id) {
		return this.mapToDto(contactRepository.findOneByAddressId(UUID.fromString(id)));
	}

	private ContactDto mapToDto(Contact contact) {
		return modelMapper.map(contact, ContactDto.class);
	}

	private Contact mapToEntity(ContactDto contact) {
	   return modelMapper.map(contact, Contact.class);
	}
	

   public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
   {
       Map<Object, Boolean> map = new ConcurrentHashMap<>();
       return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
   }



}
