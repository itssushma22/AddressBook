package com.restapi.addressbook.exception;


public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String property, String value) {
        super(String.format(
            "Resource with property %s and value %s not found." +
            "Make sure to resource exist for %s",
            property, value, property));
    }
}

