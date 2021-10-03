package com.restapi.addressbook.model;


import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="AddressBook", uniqueConstraints={@UniqueConstraint(columnNames={"name"})})
@JsonIgnoreProperties(ignoreUnknown =true)
public class AddressBook {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="scope")
	private String scope;
	
	@OneToMany(targetEntity = Contact.class, cascade= CascadeType.ALL)
	@JoinColumn(name="fldAddressBookId", referencedColumnName = "id")
	@JsonIgnoreProperties("addressBook")
	private List<Contact> contact;
	
	public AddressBook() {
		super();
	}
	public AddressBook(long id, String name, List<Contact> contact) {
	
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
	
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public List<Contact> getContact() {
		return contact;
	}
	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}
	
		
}
