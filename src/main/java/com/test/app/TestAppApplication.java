package com.test.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class TestAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}

	
	 @Value("${app.url}")
	 private String url;
	
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("test")
	public ResponseEntity<String> test() {
		return restTemplate.getForEntity(url, String.class);
	}
	
	@GetMapping("ping")
	public ResponseEntity<String> ping() {
		 return ResponseEntity.ok().body("I am Working");
	}
}
