/**
 * 
 */
package com.covid.Spring.services;

import java.util.List;

import com.covid.Spring.models.elastic.Covid19api_paysES;
import com.covid.Spring.models.elastic.Resultcovid19api_allES;
import com.covid.Spring.models.mongo.Covid19api_pays;
import com.covid.Spring.models.mongo.Resultcovid19api_all;

/**
 * @author Thomas
 *
 */
public interface Resultcovid19api_allService {

	public Resultcovid19api_all save(Resultcovid19api_all data);
	public List<Resultcovid19api_allES> saveAll();
	public List<Resultcovid19api_all> saveAllMongo(List<Resultcovid19api_all> data);
	public Covid19api_paysES save(Covid19api_pays data);
	
}
