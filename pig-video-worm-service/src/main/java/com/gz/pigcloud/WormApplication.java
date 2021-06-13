package com.gz.pigcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class WormApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WormApplication.class);
		app.run(args);
	}


}
