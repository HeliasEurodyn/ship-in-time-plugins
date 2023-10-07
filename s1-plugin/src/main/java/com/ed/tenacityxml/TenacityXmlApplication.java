package com.ed.tenacityxml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TenacityXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TenacityXmlApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(){
		return  new RestTemplate();
	}

	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
