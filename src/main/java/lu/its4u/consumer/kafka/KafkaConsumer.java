package lu.its4u.consumer.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import lu.its4u.dto.Event;

@Component
public class KafkaConsumer {
	@KafkaListener(topics = { "#{'${kafka.topic.name}'}" }, groupId = "#{'${kafka.consumer.group-id}'}")
	public void consume(ConsumerRecord<String, Event> event) {
		Event e = event.value();
		System.out.println("Recu -> \n" + "    name-> " + e.getName() + "\n" + "    description-> " + e.getDescription() + "\n____________________________________________");
	}
}