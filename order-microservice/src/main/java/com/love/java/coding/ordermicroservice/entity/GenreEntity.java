package com.love.java.coding.ordermicroservice.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
