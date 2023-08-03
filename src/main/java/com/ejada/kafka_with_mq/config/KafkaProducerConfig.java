package com.ejada.kafka_with_mq.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.ejada.kafka_with_mq.database.Payment;

/**
 * KafkaProducerConfig class is a Spring configuration class that defines the configuration for Kafka producers.
 * It provides necessary beans to set up Kafka producers with specific configurations.
 */
@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String boostrapServers;

    /**
     * Creates the configuration properties for the Kafka producer.
     *
     * @return A Map of Kafka producer configuration properties.
     */
    public Map<String, Object> producerConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, boostrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);// PaymentSerializer.class);
        return props;
    }

    /**
     * Creates the Kafka producer factory.
     *
     * @return A Kafka producer factory with the specified configuration.
     */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    /**
     * Creates the KafkaTemplate for sending messages to Kafka topics.
     *
     * @param producerFactory The Kafka producer factory to use for creating the KafkaTemplate.
     * @return A KafkaTemplate configured with the specified producer factory.
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }

}
