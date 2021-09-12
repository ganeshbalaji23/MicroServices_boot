package com.love.java.coding.bookstore.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ExceptionResponse {
	
	private String  requestedUri;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timeStamp;
	
	private String message;
	
	private ExceptionResponse() {
		this.timeStamp = LocalDateTime.now();
		
	}
	
	public ExceptionResponse(String message) {
		this();
		this.message = message;
	}
	
	public ExceptionResponse(String message, String uri) {
		this();
		this.message = message;
		this.requestedUri = uri;
	}

	public String getRequestedUri() {
		return requestedUri;
	}

	public String getMessage() {
		return message;
	}
	
}
