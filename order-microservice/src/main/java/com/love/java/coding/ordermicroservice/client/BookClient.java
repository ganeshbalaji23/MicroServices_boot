package com.love.java.coding.ordermicroservice.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.love.java.coding.ordermicroservice.model.BookEntity;

@FeignClient(name = "book-microservice")
public interface BookClient {
	
	@GetMapping("/bookstore/getAll")
	ResponseEntity<List<BookEntity>> getAllBooks();
	
	@GetMapping("/bookstore/getByGenre")
	public ResponseEntity<List<BookEntity>> getBooksByGenre(@RequestParam(value = "genre") final String genre);

}
