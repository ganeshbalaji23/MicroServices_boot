package com.love.java.coding.ordermicroservice.model;

import java.math.BigInteger;

public class GenreEntity {
	
	private BigInteger genreId;
	
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
