package com.love.java.coding.shippingmicroservice.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.love.java.coding.shippingmicroservice.entity.ShippingEntity;

@Repository
public interface ShippingRepository extends JpaRepository<ShippingEntity, Integer> {

	Set<ShippingEntity> findAllByUserId(Integer userId);

	ShippingEntity findByOrderId(Integer orderId);

	void deleteByOrderId(Integer orderId);

}
