/**
 * 
 */
package com.covid.Spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.Spring.models.elastic.Covid19api_paysES;
import com.covid.Spring.models.elastic.Resultcovid19api_allES;
import com.covid.Spring.models.mongo.Covid19api_pays;
import com.covid.Spring.models.mongo.Resultcovid19api_all;
import com.covid.Spring.repositories.elastic.Covid19api_paysESRepository;
import com.covid.Spring.repositories.elastic.Resultcovid19api_allESRepository;
import com.covid.Spring.repositories.mongo.Covid19api_paysRepository;
import com.covid.Spring.repositories.mongo.Resultcovid19api_allRepository;
import com.covid.Spring.services.Resultcovid19api_allService;

import reactor.core.publisher.Flux;

@Service
public class Resultcovid19api_allServiceImpl implements Resultcovid19api_allService {

	@Autowired
	private Resultcovid19api_allESRepository testESRepo;
	
	@Autowired
	private Resultcovid19api_allRepository testRepo;


	
	public Resultcovid19api_all save(Resultcovid19api_all data) {
		data = this.testRepo.save(data);
		Resultcovid19api_allES filmES = new Resultcovid19api_allES(data);
		System.out.println(filmES);
		this.testESRepo.save(filmES);
		return data;
	}
	
	public List<Resultcovid19api_allES> saveAll() {
		Iterable<Resultcovid19api_all> data = this.testRepo.findAll();
		Flux<Resultcovid19api_all> flux = Flux.fromIterable(data);
		flux.map(datacovid -> new Resultcovid19api_allES(datacovid)).subscribe(testES -> System.out.println(testES));
		return null;
	}
	
	public List<Resultcovid19api_all> saveAllMongo(List<Resultcovid19api_all> data) {
		data.forEach(d -> {
			System.out.println("Service : "+d);
			this.save(d);
		});
		return data;
		
	}
	
	public List<Resultcovid19api_allES> findAll() {
		return (List<Resultcovid19api_allES>) this.testESRepo.findAll();
	}

	@Override
	public Covid19api_paysES save(Covid19api_pays data) {
		// TODO Auto-generated method stub
		return null;
	}

}
