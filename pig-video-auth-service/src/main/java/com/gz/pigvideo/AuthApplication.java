package com.gz.pigvideo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;




@SpringBootApplication
@ServletComponentScan
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}
	

}
