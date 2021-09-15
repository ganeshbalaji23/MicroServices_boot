package com.love.java.coding.shippingmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ShippingMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingMicroserviceApplication.class, args);
	}

}
