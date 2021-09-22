package com.love.java.coding.bookstore.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.love.java.coding.bookstore.entity.BookEntity;
import com.love.java.coding.bookstore.exception.BookNotFoundException;
import com.love.java.coding.bookstore.exception.InvalidDataException;
import com.love.java.coding.bookstore.service.BookStoreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RefreshScope
@RequestMapping("/bookstore")
public class BookStoreController {

	@Autowired
	private BookStoreService bookService;

	/**
	 * 
	 * @param id
	 * @return
	 */

	@Operation(summary = "Get a book by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the book", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = BookEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "No Book available with the given ID", content = @Content),
			@ApiResponse(responseCode = "406", description = "Book ID is not valid", content = @Content) })
	@GetMapping("/getById")
	public ResponseEntity<BookEntity> getBookById(@RequestParam("id") final BigInteger id) {
		if (null == id) {
			throw new InvalidDataException("Book ID is not valid");
		}
		BookEntity val = bookService.findBookById(id)
				.orElseThrow(() -> new BookNotFoundException("No Book available with the given ID"));
		return ResponseEntity.status(HttpStatus.OK).body(val);
	}

	/**
	 * 
	 * @return
	 */

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Get all books from store", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = BookEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "No Books available in store", content = @Content) })
	@GetMapping("/getAll")
	public ResponseEntity<List<BookEntity>> getAllBooks() {
		List<BookEntity> books = bookService.findAllBooks();
		if (books.isEmpty()) {
			throw new BookNotFoundException("No Books available in store");
		}
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}

	/**
	 * 
	 * @param genre
	 * @return
	 */

	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found books by Genre", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = BookEntity.class)) }),
			@ApiResponse(responseCode = "404", description = "No Books found with Genre in store", content = @Content),
			@ApiResponse(responseCode = "406", description = "Not a proper Genre", content = @Content) })
	@GetMapping("/getByGenre")
	public ResponseEntity<List<BookEntity>> getBooksByGenre(@RequestParam("genre") final String genre) {

		if (null == genre || genre.trim().length() == 0) {
			throw new InvalidDataException("Not a proper Genre");
		}
		List<BookEntity> books = bookService.findBooksByGenre(genre);
		if (books.isEmpty()) {
			throw new BookNotFoundException("No Books found with Genre in store");
		}
		return ResponseEntity.status(HttpStatus.OK).body(books);
	}

	/**
	 * 
	 * @param book
	 * @return
	 */

	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "New book added successfully", content = {
			@Content(mediaType = "string") }) })
	@PostMapping(value = "/addBook", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<String> addBook(@RequestBody final BookEntity book) {
		BookEntity entity = bookService.addNewBook(book);
		return ResponseEntity.status(HttpStatus.CREATED).body("Book created successfully!");
	}

	@Value("${spring.application.name: Unable to connect to config server}")
	private String appName;

	@GetMapping("/app-name")
	public String getAppName() {
		return appName;
	}

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	private static final String TOPIC1 = "BookTopic1";

	/**
	 * Kafka example that send string
	 * 
	 * @param message
	 * @return
	 */

	@GetMapping("/publish/{message}")
	public String post(@PathVariable("message") final String message) {

		kafkaTemplate.send(TOPIC1, message);
		return "Published Sucessfully";
	}

	@Autowired
	KafkaTemplate<String, BookEntity> kafkaTemplate2;

	private static final String TOPIC2 = "BookTopic2";

	/**
	 * Kafka example that send Json
	 * 
	 * @param message
	 * @return
	 */
	@GetMapping("/publish/book/{message}")
	public String postBook(@PathVariable("message") final String message) {
		BigInteger bookId = BigInteger.valueOf(1001);
		BookEntity book = bookService.findBookById(bookId).get();
		kafkaTemplate2.send(TOPIC2, book);
		return "Published Sucessfully";
	}
			 

}
