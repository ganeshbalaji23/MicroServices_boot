package com.love.java.coding.bookstore.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(BookNotFoundException.class)
	@ResponseStatus(value= HttpStatus.NOT_FOUND)
	public final @ResponseBody ExceptionResponse handleBookNotFoundException (final BookNotFoundException e, final HttpServletRequest request) {
		
		ExceptionResponse response = new ExceptionResponse(e.getMessage(), request.getRequestURI());
		return response;
		
	}
	
	@ExceptionHandler(InvalidDataException.class)
	@ResponseStatus(value= HttpStatus.NOT_ACCEPTABLE)
	public final @ResponseBody ExceptionResponse handleBookNotFoundException (final InvalidDataException e, final HttpServletRequest request) {
		
		ExceptionResponse response = new ExceptionResponse(e.getMessage(), request.getRequestURI());
		return response;
		
	}
	
	

}
