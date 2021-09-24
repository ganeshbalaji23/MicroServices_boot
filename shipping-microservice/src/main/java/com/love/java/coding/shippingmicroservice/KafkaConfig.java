package com.love.java.coding.shippingmicroservice;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.love.java.coding.shippingmicroservice.model.BookEntity;

@EnableKafka
@Configuration
public class KafkaConfig {

	/**
	 * @return Consumer Factory for JSON
	 * @return
	 */

	@Bean
	public ConsumerFactory<String, BookEntity> consumerFactoryBook() {

		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaCustomDeserializer.class);

		//config.put(JsonDeserializer.VALUE_DEFAULT_TYPE, "com.love.java.coding.shippingmicroservice.entity.BookEntity");
		//config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");

		//JsonDeserializer<BookEntity> valueDeserializer = new JsonDeserializer<>(BookEntity.class);
		//valueDeserializer.addTrustedPackages("*");
		return new DefaultKafkaConsumerFactory<>(config/* , new StringDeserializer(), valueDeserializer */);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, BookEntity> kafkaTemplateBook() {
		ConcurrentKafkaListenerContainerFactory<String, BookEntity> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactoryBook());
		return factory;
	}

	/**
	 * 
	 * @return Consumer Factory for string
	 */
	@Bean
	public ConsumerFactory<String, String> consumerFactoryString() {

		Map<String, Object> config = new HashMap<>();
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		return new DefaultKafkaConsumerFactory<>(config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaTemplateString() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactoryString());
		return factory;
	}

}
