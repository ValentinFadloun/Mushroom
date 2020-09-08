/**
 * 
 */
package com.covid.Spring.repositories.mongo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid.Spring.models.mongo.Resultcovid19api_all;


public interface Resultcovid19api_allRepository extends MongoRepository<Resultcovid19api_all, String> {
	
	public List<Resultcovid19api_all> findByCountry(String country);

	public List<Resultcovid19api_all> findByDate(String date);

	public List<Resultcovid19api_all> findByDateGreaterThan(String date);
}
