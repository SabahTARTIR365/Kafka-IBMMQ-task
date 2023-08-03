package com.ejada.kafka_with_mq.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * MessageController is a Spring RestController responsible for handling HTTP requests related to publishing messages
 * to Kafka topics. It provides endpoints for publishing JSON and XML messages to specific Kafka topics with optional
 * parameters for specifying message keys and partitions.
 */
@RestController
@RequestMapping("api/v1/payment")
public class MessageController {
	private Logger logger = LoggerFactory. getLogger (MessageController.class);
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Constructs a new MessageController with the given KafkaTemplate.
     *
     * @param kafkaTemplate The KafkaTemplate used for sending messages to Kafka topics.
     */
    @Autowired
    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    /**
     * Endpoint for publishing JSON messages to the "json" Kafka topic.
     *
     * @param payment   The JSON message to be published.
     * @param key       Optional parameter to specify the message key. If not provided, a default key will be used.
     * @param partition Optional parameter to specify the partition to which the message should be sent.
     *                  If not provided, a default partition will be used.
     */
    @PostMapping("/json")
    public void publish(@RequestBody String payment, @RequestParam(required = false) String key,
                        @RequestParam(required = false) Integer partition) {
        // If key or partition is not provided, use default values
        String messageKey = (key != null) ? key : "1";
        int messagePartition = (partition != null) ? partition : 3;

        kafkaTemplate.send( "${kafka.topic.json}", messagePartition, messageKey, payment);
    }

    /**
     * Endpoint for publishing XML messages to the "xml" Kafka topic.
     *
     * @param payment   The XML message to be published.
     * @param key       Optional parameter to specify the message key. If not provided, a default key will be used.
     * @param partition Optional parameter to specify the partition to which the message should be sent.
     *                  If not provided, a default partition will be used.
     */
    @PostMapping("/xml")
    public void publishXml(@RequestBody String payment, @RequestParam(required = false) String key,
                           @RequestParam(required = false) Integer partition) {
        // If key or partition is not provided, use default values
        String messageKey = (key != null) ? key : "1";
        int messagePartition = (partition != null) ? partition : 3;

        kafkaTemplate.send("${kafka.topic.xml}", messagePartition, messageKey, payment);
    }
}
