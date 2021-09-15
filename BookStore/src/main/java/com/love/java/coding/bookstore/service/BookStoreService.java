package com.love.java.coding.bookstore.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import com.love.java.coding.bookstore.entity.BookEntity;

public interface BookStoreService {
	
	public Optional<BookEntity> findBookById(BigInteger id);
	
	public List<BookEntity> findAllBooks();
	
	public List<BookEntity> findBooksByGenre(String genre);
	
	public BookEntity addNewBook(BookEntity book);
}
