package com.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CloudgatewayApplication {
//	@CrossOrigin (origins = "http://localhost:4200", maxAge = 3600)
	public static void main(String[] args) {
		SpringApplication.run(CloudgatewayApplication.class, args);
	}

}
