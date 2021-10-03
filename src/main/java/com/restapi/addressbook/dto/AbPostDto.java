package com.restapi.addressbook.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import com.restapi.addressbook.dto.ContactDto;

public class AbPostDto {

	private long id;
	
	@NotBlank(message = "AddressBook is mandatory")
	private String name;
	
	private List<ContactDto> contact; 
	
	public AbPostDto() {
		super();
	}
	public AbPostDto(long id, String name, List<ContactDto> contact) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<ContactDto> getContact() {
		return contact;
	}
	public void setContact(List<ContactDto> contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "AbPostDto [id=" + id + ", name=" + name + ", contact=" + contact + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbPostDto other = (AbPostDto) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
