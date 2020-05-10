package com.example.activemq.consumer;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerController {

	@JmsListener(destination = "example.queue")
	public void consume(String message) {
		System.out.println("Consumed Message : "+ message);
	}
	
}
