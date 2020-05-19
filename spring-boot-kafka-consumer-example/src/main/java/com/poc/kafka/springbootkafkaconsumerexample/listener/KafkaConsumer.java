package com.poc.kafka.springbootkafkaconsumerexample.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.poc.kafka.springbootkafkaconsumerexample.model.User;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics = "Kafka_Example", groupId = "group_id")
	public void consume(String message) {
		System.out.println("Consumed Message: "+message);
	}
	
	@KafkaListener(topics = "Kafka_Example_Json1", groupId = "group_json",
			containerFactory = "userKafkaListenerFactory")
	public void consumeJson(User user) {
		System.out.println("Consumed JSON Message: >" +user);
	}
}
