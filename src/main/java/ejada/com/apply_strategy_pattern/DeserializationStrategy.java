package ejada.com.apply_strategy_pattern;

import com.ejada.kafka_with_mq.database.Payment;

interface DeserializationStrategy {
	Payment deserialize(String text);
}
