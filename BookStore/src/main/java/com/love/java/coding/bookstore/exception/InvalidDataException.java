package com.love.java.coding.bookstore.exception;

public class InvalidDataException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1575830322144997357L;

	public InvalidDataException() {
		super();
	}
	
	public InvalidDataException(String message) {
		super(message);
	}

}
