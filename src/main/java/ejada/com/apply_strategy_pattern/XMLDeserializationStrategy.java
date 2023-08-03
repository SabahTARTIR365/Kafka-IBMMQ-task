package ejada.com.apply_strategy_pattern;

import com.ejada.kafka_with_mq.database.Payment;
import com.ejada.kafka_with_mq.exception.PaymentDeserializationException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XMLDeserializationStrategy implements DeserializationStrategy {
	private XmlMapper xmlMapper; //= new XmlMapper();
	
	XMLDeserializationStrategy(){
		
		 xmlMapper= new XmlMapper();
	}
	
	@Override
	public Payment deserialize(String text) {
		 try {
	            return xmlMapper.readValue(text, Payment.class);
	        } catch (Exception e) {
	            throw new PaymentDeserializationException("Error deserializing XML to Payment object: " + e.getMessage(),
	                    e);
	        }
	}

}
