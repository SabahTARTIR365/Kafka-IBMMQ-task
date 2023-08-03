package ejada.com.apply_strategy_pattern;

import com.ejada.kafka_with_mq.database.Payment;

class PaymentProcessor {
	private DeserializationStrategy deserializationStrategy;

	public void setDeserializationStrategy(DeserializationStrategy deserializationStrategy) {
		this.deserializationStrategy = deserializationStrategy;
	}

	public Payment processPayment(String text) {
		return deserializationStrategy.deserialize(text);
	}
	
	 public Payment processXmlPayment(String xmlText) {
	        setDeserializationStrategy(new XMLDeserializationStrategy());
	        return processPayment(xmlText);
	    }

	    public Payment processJsonPayment(String jsonText) {
	        setDeserializationStrategy(new JSONDeserializationStrategy());
	        return processPayment(jsonText);
	    }

	
	
}
