package com.love.java.coding.ordermicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMicroserviceApplication.class, args);
	}

}
