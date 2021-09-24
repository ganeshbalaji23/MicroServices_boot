package com.love.java.coding.shippingmicroservice;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.love.java.coding.shippingmicroservice.model.BookEntity;

public class KafkaCustomDeserializer implements Deserializer<BookEntity> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public BookEntity deserialize(String topic, byte[] data) {
		try {
			if (data == null) {
				System.out.println("Null received in deserializing");
				return null;
			}
			System.out.println("Deserializing object...");
			return objectMapper.readValue(new String(data, "UTF-8"), BookEntity.class);
		} catch (Exception e) {
			throw new SerializationException("Error Deserializing byte[] to BookEntity");
		}

	}

}
