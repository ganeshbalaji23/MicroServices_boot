package com.love.java.coding.bookstore;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.love.java.coding.bookstore.entity.BookEntity;

public class KafkaCustomSerializer implements Serializer<BookEntity> {
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public byte[] serialize(String topic, BookEntity data) {
		
		try {
			if(data == null) {
				System.out.println("Null received at serializing");
				return null;
			}
			
			System.out.println("Serializing object...");
			return objectMapper.writeValueAsBytes(data);
		} catch(Exception e) {
			throw new SerializationException("Error when serializing BookEntity to byte[]");
		}
	}
}
