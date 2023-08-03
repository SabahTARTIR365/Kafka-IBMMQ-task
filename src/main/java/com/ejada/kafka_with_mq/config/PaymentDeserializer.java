package com.ejada.kafka_with_mq.config;

import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejada.kafka_with_mq.database.Payment;
import com.ejada.kafka_with_mq.exception.PaymentDeserializationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Custom Kafka deserializer for deserializing Payment objects from JSON and XML formats.
 * This class implements the Deserializer interface provided by Kafka to customize the deserialization process.
 */

@Service
public class PaymentDeserializer implements Deserializer<Payment> {
 @Autowired
    private ObjectMapper objectMapper;// = new ObjectMapper();
    private XmlMapper xmlMapper; //= new XmlMapper();

    /**
     * Deserialize the Payment object from the provided byte array (assumed to be in JSON format).
     *
     * @param topic The topic associated with the data. Not used in this implementation.
     * @param data  The byte array representing the serialized Payment object in JSON format.
     * @return The deserialized Payment object.
     * @throws PaymentDeserializationException If an error occurs during deserialization.
     */
 public PaymentDeserializer(){
	 xmlMapper=new XmlMapper();
 }
    @Override
    public Payment deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, Payment.class);
        } catch (Exception e) {
            throw new PaymentDeserializationException("Error deserializing Payment object: " + e.getMessage(), e);
        }
    }

    /**
     * Deserialize the Payment object from the provided JSON string.
     *
     * @param json The JSON string representing the serialized Payment object.
     * @return The deserialized Payment object.
     * @throws PaymentDeserializationException If an error occurs during deserialization.
     */
    public Payment fromJson(String json) {
        try {
            return objectMapper.readValue(json, Payment.class);
        } catch (Exception e) {
            throw new PaymentDeserializationException("Error deserializing JSON to Payment object:  " + e.getMessage(),
                    e);
        }
    }

    /**
     * Deserialize the Payment object from the provided XML string.
     *
     * @param xml The XML string representing the serialized Payment object.
     * @return The deserialized Payment object.
     * @throws PaymentDeserializationException If an error occurs during deserialization.
     */
    public Payment fromXml(String xml) {
        try {
            return xmlMapper.readValue(xml, Payment.class);
        } catch (Exception e) {
            throw new PaymentDeserializationException("Error deserializing XML to Payment object: " + e.getMessage(),
                    e);
        }
    }
}
