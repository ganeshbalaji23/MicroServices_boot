package com.love.java.coding.bookstore.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_book_genre")
public class GenreEntity {
	
	@Id
	@Column(name = "genre_id")
	private BigInteger genreId;
	
	@Column(name = "genre_name")
	private String name;

	public BigInteger getGenreId() {
		return genreId;
	}

	public void setGenreId(BigInteger genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
