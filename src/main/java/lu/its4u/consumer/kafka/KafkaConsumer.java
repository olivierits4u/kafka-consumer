package lu.its4u.consumer.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lu.its4u.dto.Data;
import lu.its4u.dto.Event;

@Component
public class KafkaConsumer {
	@KafkaListener(topics = { "#{'${kafka.topic.name}'}" }, groupId = "#{'${kafka.consumer.group-id}'}")
	public void consume(ConsumerRecord<String, Data> data) {
		Data e = data.value();

		System.out.println("recu:\n -- Id: " + e.getId() + "\n -- Description: " + e.getDescription() + "\n -- Name:"
				+ e.getName() + "\n -- Date: " + e.getDate() + "\n -_______________________-");

	}

}