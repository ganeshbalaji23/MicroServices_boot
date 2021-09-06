package com.love.java.coding.bookstore.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

@Entity
@Table(name="t_book_store")
public class BookEntity {
	
	@Id
	@Column(name = "book_id")
	private BigInteger bookId;
	
	@NonNull
	@Column(name = "isbn")
	private BigInteger isbn;
	
	@Column(name = "book_name")
	private String bookName;
	
	@Column(name = "author")
	private String author;
	
	@ManyToOne
	@JoinColumn(name = "genreId")
	private GenreEntity genre;

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
	
	
}
