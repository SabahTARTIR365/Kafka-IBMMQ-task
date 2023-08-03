package com.ejada.kafka_with_mq.config;


import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import com.ejada.kafka_with_mq.database.Payment;
//consumer
/**
 * Kafka consumer configuration class for Payment messages.
 * This class configures the Kafka consumer properties and provides a factory
 * for creating Kafka listener containers.
 */
@Configuration
public class PaymentConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String boostrapServers;
	
	/**
	 * Creates and returns the Kafka consumer configuration properties.
	 *
	 * @return A map containing the Kafka consumer configuration properties.
	 */
	public Map<String, Object> consumerConfig() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapServers);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class); //PaymentDeserializer.class);
	   //props.put(ConsumerConfig.GROUP_ID_CONFIG, "GI1"); // Set the group ID to a specific value if needed.
		return props;
	}
	
	/**
	 * Creates and returns the Kafka consumer factory.
	 *
	 * @return The KafkaConsumerFactory configured with the consumer configuration properties.
	 */
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		return new DefaultKafkaConsumerFactory<>(consumerConfig());
	}
	
	/**
	 * Creates and returns the Kafka listener container factory.
	 *
	 * @param consumerFactory The KafkaConsumerFactory used to create the listener container.
	 * @return The KafkaListenerContainerFactory for creating Kafka message listener containers.
	 */
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> factory(
			ConsumerFactory<String, String> consumerFactory) {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory);
		return factory;
	}
}

