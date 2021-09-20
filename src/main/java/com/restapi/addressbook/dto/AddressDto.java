package com.restapi.addressbook.dto;

import java.util.UUID;

public class AddressDto {
	
	private UUID addressBookId;
	private String parentGroup;
	private UUID addressId;
	private String displayName;
	private String phoneNumber;
	private String type;
	
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
	
	public UUID getAddressId() {
		return addressId;
	}
	public void setAddressId(UUID addressId) {
		this.addressId = addressId;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	
}
