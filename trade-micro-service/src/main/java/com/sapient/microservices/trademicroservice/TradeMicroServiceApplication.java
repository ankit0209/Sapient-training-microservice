package com.sapient.microservices.trademicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TradeMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeMicroServiceApplication.class, args);
	}

}
