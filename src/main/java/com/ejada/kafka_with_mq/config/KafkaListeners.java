package com.ejada.kafka_with_mq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.ejada.kafka_with_mq.database.Payment;
import com.ejada.kafka_with_mq.database.PaymentService;
/**
 * KafkaListeners class is a Spring component that serves as Kafka consumers for processing messages from XML and JSON topics.
 * It is responsible for listening to Kafka topics and processing the incoming messages.
 */
@Component
public class KafkaListeners {
    
    private final PaymentService paymentService;    
    private PaymentDeserializer paymentDeserializer;// inject service or bean
	private Logger logger = LoggerFactory. getLogger (KafkaListeners.class);
	
    /**
     * Constructor for KafkaListeners that injects the required dependencies.
     *
     * @param paymentService         The service responsible for handling payment-related operations.
     * @param paymentDeserializer    The service responsible for handling payment-deserialization operations.
     */

    public KafkaListeners(PaymentService paymentService,PaymentDeserializer paymentDeserializer) {
      this.paymentService = paymentService;
      this.paymentDeserializer=paymentDeserializer;
    }

    /**
     * Kafka listener method that consumes XML payment messages from the specified topic.
     * and call method to save it to database .
     * @param payment The XML payment message received from Kafka.
     */
    @KafkaListener(topics = "${kafka.topic.xml}", groupId = "${kafka.groupId.xml}")
    void xmllistener(String payment) {
        logger.info("XML Listener received: " + payment );
        Payment deserialized_payment = paymentDeserializer.fromXml(payment);
        logger.info("Deserialize the XML payment message" + deserialized_payment );
        // Add the payment to the payment service
        paymentService.addPayment(deserialized_payment);
        logger.info("The payment is added to the database" + deserialized_payment );
    }

  
 


    /**
     * Kafka listener method for the JSON topic.
     * This method listens to the Kafka topic configured in the application properties
     * and processes incoming JSON messages and save them to the database.
     *
     * @param payment  The JSON message received from the Kafka topic.
     */
    @KafkaListener(topics = "${kafka.topic.json}", groupId = "${kafka.groupId.json}")
    void jsonlistener(String payment) {
        logger. info("JSON Listener received:"+ payment );
        Payment deserialized_payment = paymentDeserializer.fromJson(payment);
        logger.info("Deserialize the XML payment message" + deserialized_payment );
        paymentService.addPayment(deserialized_payment);
        logger.info("The payment is added to the database" + deserialized_payment );
    }
}
