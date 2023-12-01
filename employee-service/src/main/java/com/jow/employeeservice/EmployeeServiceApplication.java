package com.jow.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class EmployeeServiceApplication {
	//@Bean
	//public RestTemplate restTemplate(){
		//return new RestTemplate();
	//}
	//commented rest template to achieve non-blocking
	//introducing new web client from spring reactive frame work
	//@Bean
	//public WebClient webClient(){
		//return WebClient.builder().build();
	//}

	public static void main(String[] args) {
		SpringApplication.run(EmployeeServiceApplication.class, args);
	}

}
