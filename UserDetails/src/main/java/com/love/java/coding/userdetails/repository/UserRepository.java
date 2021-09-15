package com.love.java.coding.userdetails.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.love.java.coding.userdetails.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, BigInteger> {

	boolean existsByUserName(String userName);

	void deleteByUserName(String userName);

	Optional<UserEntity> findByUserName(String userName);

}
