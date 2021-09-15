package com.love.java.coding.bookstore.service.impl;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import com.love.java.coding.bookstore.entity.BookEntity;
import com.love.java.coding.bookstore.repository.BookStoreRepository;
import com.love.java.coding.bookstore.service.BookStoreService;

@Service
public class BookStoreServiceImpl implements BookStoreService {

	@Autowired
	private BookStoreRepository bookRepository;
	
	@Override
	public Optional<BookEntity> findBookById(BigInteger id) {
		return bookRepository.findById(id);
	}

	@Override
	public List<BookEntity> findAllBooks() {
		return Streamable.of(bookRepository.findAll()).toList();
	}

	@Override
	public List<BookEntity> findBooksByGenre(String genre) {
		return bookRepository.findByGenre_name(genre);
	}

	@Override
	public BookEntity addNewBook(BookEntity book) {
		return bookRepository.save(book);
	}
}
