package com.ejada.kafka_with_mq.config;

import org.apache.kafka.common.serialization.Serializer;

import com.ejada.kafka_with_mq.database.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PaymentSerializer implements Serializer<Payment> {

	private ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public byte[] serialize(String topic, Payment payment) {
		try {
			return objectMapper.writeValueAsBytes(payment);
		} catch (Exception e) {
			throw new RuntimeException("Error serializing Payment object: " + e.getMessage(), e);
		}
	}
}
