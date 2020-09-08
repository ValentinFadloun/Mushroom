/**
 * 
 */
package com.covid.Spring.services;

import java.util.List;

import com.covid.Spring.models.elastic.Covid19api_paysES;
import com.covid.Spring.models.mongo.Covid19api_pays;

/**
 * @author Thomas
 *
 */
public interface Covid19api_paysService {

	public Covid19api_paysES save(Covid19api_pays data);

	public List<Covid19api_pays> findAllByCurrentDate();

	public Long saveTodayDataES();

	public List<Covid19api_paysES> findAll();

	public List<Covid19api_pays> findAllMongo();

	
}
