package com.covid.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.covid.Spring.models.mongo.Test;
import com.covid.Spring.services.TestService;
import com.covid.Spring.services.impl.TestServiceImpl;

@SpringBootApplication
public class Application {
	@Autowired
	private TestService testService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
