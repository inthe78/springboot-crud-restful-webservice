package com.sport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SoccerManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerManagementSystemApplication.class, args);
	}

}
