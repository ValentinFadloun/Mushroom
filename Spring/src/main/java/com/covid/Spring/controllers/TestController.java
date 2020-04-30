package com.covid.Spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.Spring.models.elastic.Covid19api_paysES;
import com.covid.Spring.models.mongo.Covid19api_pays;
import com.covid.Spring.models.mongo.Resultcovid19api_all;
import com.covid.Spring.services.Covid19api_paysService;
import com.covid.Spring.services.Resultcovid19api_allService;

@RestController
@CrossOrigin
@RequestMapping("covid")
public class TestController {

	@Autowired
	private Resultcovid19api_allService resultcovid19api_allService;
	
	@Autowired
	private Covid19api_paysService covid19api_paysService;

	@PostMapping("")
	public Resultcovid19api_all save(@RequestBody Resultcovid19api_all data) {
		System.out.println(data);
		return this.resultcovid19api_allService.save(data);
	}

	@GetMapping("")
	public void saveAll() {
		this.resultcovid19api_allService.saveAll();
	}
	
	@PostMapping("pays")
	public Covid19api_paysES save(@RequestBody Covid19api_pays data ) {
		System.out.println("controller : "+data);
		return this.covid19api_paysService.save(data);
	}
}
	