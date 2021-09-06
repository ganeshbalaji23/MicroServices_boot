package com.love.java.coding.bookstore.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.love.java.coding.bookstore.entity.BookEntity;

@Repository
public interface BookStoreRepository extends CrudRepository<BookEntity, BigInteger>{

	public List<BookEntity> findByGenre_name(String genre);

}
