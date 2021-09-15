package com.love.java.coding.ordermicroservice.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.love.java.coding.ordermicroservice.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

	Set<OrderEntity> findAllByCustomerId(Integer userId);

}
