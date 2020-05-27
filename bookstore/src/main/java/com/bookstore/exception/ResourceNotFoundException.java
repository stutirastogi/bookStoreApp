package com.bookstore.exception;


public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
