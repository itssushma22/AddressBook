package com.restapi.addressbook.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Address")
@Component
@JsonIgnoreProperties(ignoreUnknown =true)
public class Address {


	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	@Column(name="fldAddressId")
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
	
//	@Column(name="fldAddressFrom")
//	private Date addressFrom;
//	
//	@Column(name="fldAddressTo")
//	private Date addressTo;
	
	@Column(name="fldAddressBookId")
	private UUID addressBookId;
	
	@Column(name="fldParentGroup")
	private String parentGroup;

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

//	public Date getAddressFrom() {
//		return addressFrom;
//	}
//
//	public void setAddressFrom(Date addressFrom) {
//		this.addressFrom = addressFrom;
//	}
//
//	public Date getAddressTo() {
//		return addressTo;
//	}
//
//	public void setAddressTo(Date addressTo) {
//		this.addressTo = addressTo;
//	}

	public UUID getAddressBookId() {
		return addressBookId;
	}

	public void setAddressBookId(UUID addressBookId) {
		this.addressBookId = addressBookId;
	}

	public String getParentGroup() {
		return parentGroup;
	}

	public void setParentGroup(String parentGroup) {
		this.parentGroup = parentGroup;
	}
	
	
	
	
	
	

}
