/**
 * 
 */
package com.covid.Spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.Spring.models.elastic.Resultcovid19api_allES;
import com.covid.Spring.models.mongo.Resultcovid19api_all;
import com.covid.Spring.repositories.elastic.Resultcovid19api_allESRepository;
import com.covid.Spring.repositories.mongo.Resultcovid19api_allRepository;
import com.covid.Spring.services.Resultcovid19api_allService;
import com.covid.Spring.tools.DateTool;

import reactor.core.publisher.Flux;

@Service
public abstract class Resultcovid19api_allServiceImpl implements Resultcovid19api_allService {

	@Autowired
	private Resultcovid19api_allESRepository ESRepo;

	@Autowired
	private Resultcovid19api_allRepository mongoRepo;

	public Resultcovid19api_all save(Resultcovid19api_all data) {
		data = this.mongoRepo.save(data);
		Resultcovid19api_allES CovidAllES = new Resultcovid19api_allES(data);
		this.ESRepo.save(CovidAllES);
		return data;
	}

	public List<Resultcovid19api_all> findAllByCurrentDate() {
		String s = DateTool.getCurrentDateMinusOneDay();
		return this.mongoRepo.findByDateGreaterThan(s);

	}

	public Long saveTodayDataES() {
		Iterable<Resultcovid19api_all> data = this.findAllByCurrentDate();
		Flux<Resultcovid19api_all> flux = Flux.fromIterable(data);
		flux.map(datacovid -> new Resultcovid19api_allES(datacovid)).subscribe(ESObject -> this.ESRepo.save(ESObject));
		return flux.count().block();
	}

	public List<Resultcovid19api_allES> findAll() {
		return (List<Resultcovid19api_allES>) this.ESRepo.findAll();
	}

	public List<Resultcovid19api_all> findAllMongo() {
		return (List<Resultcovid19api_all>) this.mongoRepo.findAll();
	}

}
