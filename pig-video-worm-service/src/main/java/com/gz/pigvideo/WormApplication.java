package com.gz.pigvideo;

import com.gz.pigvideo.service.AutoWormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling
public class WormApplication {

	@Autowired
	private AutoWormService autoWormService;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(WormApplication.class);
		app.run(args);
	}

	public void run(String... arg0) throws Exception {
		autoWormService.autoWormTask();
	}


}
