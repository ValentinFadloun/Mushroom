package com.covid.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.covid.Spring.models.elastic.Covid19api_paysES;
import com.covid.Spring.models.mongo.Covid19api_pays;
import com.covid.Spring.models.mongo.Test;
import com.covid.Spring.services.TestService;
import com.covid.Spring.services.impl.TestServiceImpl;
import com.covid.Spring.tools.CountryNametoISO;
import com.covid.Spring.tools.PaysCsv;

@SpringBootApplication
public class Application {
	@Autowired
	private TestService testService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		Covid19api_paysES test = new Covid19api_paysES(
				new Covid19api_pays(
						"", 1.3, "France", 34, 31, 1.4, 50, "2020-12-02",1.2));
		System.out.println(test);
		System.out.println(CountryNametoISO.getValueFromCsv("France", PaysCsv.NOMPAYSFR, PaysCsv.ISOCODE2));
	}

}
