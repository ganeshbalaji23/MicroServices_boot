package com.love.java.coding.shippingmicroservice.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.love.java.coding.shippingmicroservice.model.BookEntity;

@Service
public class KafkaConsumer {

	@KafkaListener(topics = "BookTopic1", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed Message:" + message);
	}

	@KafkaListener(topics = "BookTopic2", groupId = "group_json", containerFactory = "kafkaTemplateBook")
	public void consume(BookEntity book) {
		System.out.println("Consumed Message:" + book);
	}

}
