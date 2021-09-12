package com.love.java.coding.bookstore.exception;

public class BookNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5662674486406449996L;
	
	public BookNotFoundException() {
		super();
	}
	
	public BookNotFoundException(String message) {
		super(message);
	}

}
