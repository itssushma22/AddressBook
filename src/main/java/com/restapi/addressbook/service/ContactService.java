package com.restapi.addressbook.service;

import java.util.List;
import com.restapi.addressbook.dto.ContactDto;

public interface ContactService {

	ContactDto save(long addressbookId, ContactDto contactDto);
	ContactDto delete(long addressbookId, String contactId);
	List<ContactDto> findAllDistinctRecords();
	ContactDto findOneByAddressId(String id);
}
