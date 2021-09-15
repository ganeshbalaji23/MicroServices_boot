package com.love.java.coding.userdetails.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.love.java.coding.userdetails.entity.PaymentEntity;
import com.love.java.coding.userdetails.entity.UserEntity;

@Repository
public interface PaymentDetailsRepository extends JpaRepository<PaymentEntity, Integer> {

	Set<PaymentEntity> findAllByUserId(UserEntity user);

}
