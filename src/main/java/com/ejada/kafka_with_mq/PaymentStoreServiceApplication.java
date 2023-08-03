package com.ejada.kafka_with_mq;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import com.ejada.kafka_with_mq.config.PaymentSerializer;
import com.ejada.kafka_with_mq.database.Payment;

@SpringBootApplication
public class PaymentStoreServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentStoreServiceApplication.class, args);
	}
	
	
}
