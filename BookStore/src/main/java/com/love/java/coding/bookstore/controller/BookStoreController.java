package com.love.java.coding.bookstore.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.love.java.coding.bookstore.entity.BookEntity;
import com.love.java.coding.bookstore.service.BookStoreService;

@RestController
@RequestMapping("/bookstore")
public class BookStoreController {
	
	@Autowired
	private BookStoreService bookService;
	
	@GetMapping("/getById")
	public ResponseEntity<BookEntity> getBookById(@RequestParam("id") final BigInteger id) {
		BookEntity book = bookService.findBookById(id);
		return ResponseEntity.status(HttpStatus.OK).body(book);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<BookEntity>> getAllBooks() {
		List<BookEntity> books = bookService.findAllBooks();
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}
	
	@GetMapping("/getByGenre")
	public ResponseEntity<List<BookEntity>> getBooksByGenre(@RequestParam("genre") final String genre) {
		List<BookEntity> books = bookService.findBooksByGenre(genre);
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}
	
	@PostMapping(value="/addBook",
			consumes = {MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<String> addBook(@RequestBody final BookEntity book) {
		bookService.addNewBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body("Book created successfully!");
	}

}
