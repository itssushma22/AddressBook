package com.restapi.addressbook.exception;


public class ResourceAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ResourceAlreadyExistsException(String property, String value) {
        super(String.format(
            "Resource with property %s and value %s already exists." +
            "Make sure to insert a unique value for %s",
            property, value, property));
    }
}
