package com.gz.pigvideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.gz.pigvideo.filter.MyFilter;



@SpringBootApplication
@EnableZuulProxy
@ServletComponentScan
public class GatewayServiceZuulApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceZuulApplication.class, args);
	}
	
	@Bean
	public MyFilter tokenFilter() {
		return new MyFilter();
	}

}
