package com.ejada.kafka_with_mq.exception;

public class PaymentDeserializationException extends RuntimeException {

	public PaymentDeserializationException(String message, Throwable cause) {
		super(message, cause);
	}
}
