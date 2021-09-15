package com.love.java.coding.userdetails.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.love.java.coding.userdetails.entity.AddressEntity;
import com.love.java.coding.userdetails.entity.UserEntity;

@Repository
public interface UserAddressRepository extends JpaRepository<AddressEntity, Integer> {

	Set<AddressEntity> findAllByUserId(UserEntity user);

}
