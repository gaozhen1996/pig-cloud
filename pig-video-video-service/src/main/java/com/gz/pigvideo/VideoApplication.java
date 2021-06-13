package com.gz.pigvideo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan
public class VideoApplication {

	private static final Logger log = LoggerFactory.getLogger(VideoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VideoApplication.class, args);
		log.info("-----------video service run success-------------");
	}
	
	
}
