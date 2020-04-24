package com.covid.Spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.covid.Spring.models.mongo.Test;
import com.covid.Spring.services.TestService;

@RestController
@CrossOrigin
@RequestMapping("test")
public class TestController {

	@Autowired
	private TestService testService;
	
	@PostMapping("")
	public Test save(@RequestBody Test test) {
		return this.testService.save(test);
	}
	
	@GetMapping("")
	public void saveAll() {
		this.testService.saveAll();
	}
}
