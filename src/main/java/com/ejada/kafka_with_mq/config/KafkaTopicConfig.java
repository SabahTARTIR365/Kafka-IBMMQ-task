package com.ejada.kafka_with_mq.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * Configuration class for defining Kafka topics and their partitions.
 * This class uses Spring's `@Configuration` annotation to indicate that it
 * contains bean definitions that should be processed by the Spring container.
 */
@Configuration
public class KafkaTopicConfig {

    /**
     * Constant for the number of partitions for both XML and JSON topics.
     * Modify this value to change the number of partitions for all topics.
     */
    private static final int TOPIC_PARTITIONS = 5;
    private static final String TOPIC_XML = "XML";
    private static final String TOPIC_JSON = "JSON";

    /**
     * Bean definition for creating the XML topic with a specified number of partitions.
     *
     * @return A NewTopic object representing the XML topic with the defined number of partitions.
     */
    @Bean
    public NewTopic createXmlTopic() {
        return TopicBuilder.name(TOPIC_XML ).partitions(TOPIC_PARTITIONS).build();
    }

    /**
     * Bean definition for creating the JSON topic with a specified number of partitions.
     *
     * @return A NewTopic object representing the JSON topic with the defined number of partitions.
     */
    @Bean
    public NewTopic createJsonTopic() {
        return TopicBuilder.name(TOPIC_JSON).partitions(TOPIC_PARTITIONS).build();
    }
}
