/**
 * 
 */
package com.covid.Spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.Spring.models.elastic.TestES;
import com.covid.Spring.models.mongo.Test;
import com.covid.Spring.repositories.elastic.TestESRepository;
import com.covid.Spring.repositories.mongo.TestRepository;
import com.covid.Spring.services.TestService;

@Service
public class TestServiceImpl implements TestService {

	
	@Autowired
	private TestESRepository testESRepo;
	
	@Autowired
	private TestRepository testRepo;
	
	public Test save(Test test) {
		test = this.testRepo.save(test);
		TestES filmES = new TestES(test);
		this.testESRepo.save(filmES);
		return test;

	}
}
