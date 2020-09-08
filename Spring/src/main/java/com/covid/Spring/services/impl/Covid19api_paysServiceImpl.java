/**
 * 
 */
package com.covid.Spring.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.Spring.models.elastic.Covid19api_paysES;
import com.covid.Spring.models.mongo.Covid19api_pays;
import com.covid.Spring.repositories.elastic.Covid19api_paysESRepository;
import com.covid.Spring.repositories.mongo.Covid19api_paysRepository;
import com.covid.Spring.services.Covid19api_paysService;
import com.covid.Spring.tools.DateTool;

/**
 * @author Thomas
 *
 */
@Service
public class Covid19api_paysServiceImpl implements Covid19api_paysService {

	
	@Autowired
	private Covid19api_paysRepository paysrepoMongo;
	
	@Autowired
	private Covid19api_paysESRepository paysrepoES;


	public Covid19api_paysES save(Covid19api_pays data) {
		Covid19api_paysES covidData = new Covid19api_paysES(data);
		return this.paysrepoES.save(covidData);
	}


	@Override
	public List<Covid19api_pays> findAllByCurrentDate() {
		String s = DateTool.getCurrentDateMinusOneDay();
		return this.paysrepoMongo.findByDateGreaterThan(s);
	}


	@Override
	public Long saveTodayDataES() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Covid19api_paysES> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Covid19api_pays> findAllMongo() {
		// TODO Auto-generated method stub
		return null;
	}

}
