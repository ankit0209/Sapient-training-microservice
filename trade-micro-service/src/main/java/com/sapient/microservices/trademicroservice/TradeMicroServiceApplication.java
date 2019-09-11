package com.sapient.microservices.trademicroservice;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
@EnableFeignClients("com.sapient.microservices.trademicroservice")
@EnableDiscoveryClient
public class TradeMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeMicroServiceApplication.class, args);
		
	}
	
	


}
