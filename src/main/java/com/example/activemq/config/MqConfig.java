package com.example.activemq.config;



import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class MqConfig {

	@Value("${activemq.broker.url}")
	private String brokerUrl;
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("example.queue");  //Create the Queue	
	}
	
	@Bean
	public ActiveMQConnectionFactory getActiveMQConnectionFactory() {
		ActiveMQConnectionFactory fac = new ActiveMQConnectionFactory();
		fac.setBrokerURL(brokerUrl);
		return fac;
		}
	
	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(getActiveMQConnectionFactory());
	}
	
}
