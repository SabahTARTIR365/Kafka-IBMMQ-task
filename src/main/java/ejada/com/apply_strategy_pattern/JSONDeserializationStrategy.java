package ejada.com.apply_strategy_pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.ejada.kafka_with_mq.database.Payment;
import com.ejada.kafka_with_mq.exception.PaymentDeserializationException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONDeserializationStrategy implements DeserializationStrategy {

	@Autowired
    private ObjectMapper objectMapper;
	@Override
	public Payment deserialize(String text) {
		  try {
	            return objectMapper.readValue(text, Payment.class);
	        } catch (Exception e) {
	            throw new PaymentDeserializationException("Error deserializing JSON to Payment object:  " + e.getMessage(),
	                    e);
	        }
	}

}
