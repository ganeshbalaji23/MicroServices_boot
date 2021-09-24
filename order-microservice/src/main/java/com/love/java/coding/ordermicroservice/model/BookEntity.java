package com.love.java.coding.ordermicroservice.model;

import java.math.BigInteger;

public class BookEntity {
	
	private BigInteger bookId;
	
	private BigInteger isbn;
	
	private String bookName;
	
	private String author;
	
	private GenreEntity genre;
	
	private Integer quantity;

	public BigInteger getBookId() {
		return bookId;
	}

	public void setBookId(BigInteger bookId) {
		this.bookId = bookId;
	}

	public BigInteger getIsbn() {
		return isbn;
	}

	public void setIsbn(BigInteger isbn) {
		this.isbn = isbn;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public GenreEntity getGenre() {
		return genre;
	}

	public void setGenre(GenreEntity genre) {
		this.genre = genre;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
