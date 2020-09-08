package com.covid.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.covid.Spring.controllers.TestController;
import com.covid.Spring.models.elastic.Covid19api_paysES;
import com.covid.Spring.models.mongo.Covid19api_pays;
import com.covid.Spring.models.mongo.Test;
import com.covid.Spring.services.TestService;
import com.covid.Spring.services.impl.Resultcovid19api_allServiceImpl;
import com.covid.Spring.services.impl.TestServiceImpl;
import com.covid.Spring.tools.CountryNametoISO;
import com.covid.Spring.tools.PaysCsv;

@SpringBootApplication
public class Application {
	@Autowired
	private static Resultcovid19api_allServiceImpl testService;
	
	
	public static void main(String[] args) {

		SpringApplication sa = new SpringApplication(Application.class);
        ApplicationContext c = sa.run(args);
        TestController bean = c.getBean(TestController.class);
        System.out.println(bean.findAllByCurrentDate());
	}
	}
