/**
 * 
 */
package com.covid.Spring.services;

import java.util.List;


import com.covid.Spring.models.elastic.Resultcovid19api_allES;
import com.covid.Spring.models.mongo.Resultcovid19api_all;

/**
 * @author Thomas
 *
 */
public interface Resultcovid19api_allService {

	public Long saveTodayDataES();
	public List<Resultcovid19api_allES> findAll();
	public List<Resultcovid19api_all> findAllMongo();
	public List<Resultcovid19api_all> findAllByCurrentDate();
	public Resultcovid19api_all save(Resultcovid19api_all data);
	
}
