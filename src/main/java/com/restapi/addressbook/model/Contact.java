package com.restapi.addressbook.model;


import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.restapi.addressbook.util.AddressType;

@Entity
@Table(name="contact", uniqueConstraints={@UniqueConstraint(columnNames={"fldPhoneNumber"})})
@Component
@JsonIgnoreProperties(ignoreUnknown =true)
public class Contact {


	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name="fldAddressId", columnDefinition = "BINARY(16)")
	private UUID addressId;
	
	@Column(name="fldFirstName")
	private String firstName;
	
	@Column(name="fldLastName")
	private String lastName;
	
	@Column(name="fldPreferredName")
	private String preferredName;
	
	@Column(name="fldPhoneNumber")
	private String phoneNumber;
	
	@Column(name="fldCity")
	private String city;
	
	@Column(name="fldCountry")
	private String country;
	
	@Column(name="fldState")
	private String state;
	
	@Column(name="fldStreetName")
	private String streetName;
	
	@Column(name="fldStreetNumber")
	private String streetNumber;
	
	@Column(name="fldAddressType")
	private String addressType;
	
	@Enumerated(EnumType.STRING)
	@Column(name="AddressType")
	private AddressType type ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "fldAddressBookId", nullable = false)
	private AddressBook addressBook;

	
	public Contact() {
		super();
	}
	
	public Contact(String firstName, String lastName, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public Contact(UUID addressId,  String firstName, String lastName, String phoneNumber) {
		this.addressId = addressId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}

	public UUID getAddressId() {
		return addressId;
	}

	public void setAddressId(UUID addressId) {
		this.addressId = addressId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPreferredName() {
		return preferredName;
	}

	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public AddressType getType() {
		return type;
	}

	public void setType(AddressType type) {
		this.type = type;
	}

	public AddressBook getAddressBook() {
		return addressBook;
	}

	public void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}



}
