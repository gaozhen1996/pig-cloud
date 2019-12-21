package com.gz.pigvideo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan
public class PlanApplication {

	private static final Logger log = LoggerFactory.getLogger(PlanApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PlanApplication.class, args);
		log.info("-----------plan service run success-------------");
	}


}
