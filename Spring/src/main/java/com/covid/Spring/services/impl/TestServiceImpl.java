/**
 * 
 */
package com.covid.Spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.Spring.models.elastic.TestES;
import com.covid.Spring.models.mongo.Test;
import com.covid.Spring.repositories.elastic.TestESRepository;
import com.covid.Spring.repositories.mongo.TestRepository;
import com.covid.Spring.services.TestService;

import reactor.core.publisher.Flux;

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
	
	public List<TestES> saveAll() {
		Iterable<Test> data = this.testRepo.findAll();
		Flux<Test> flux = Flux.fromIterable(data);
		flux.map(test -> new TestES(test)).subscribe(testES -> System.out.println(testES));
		return null;
	}
}
