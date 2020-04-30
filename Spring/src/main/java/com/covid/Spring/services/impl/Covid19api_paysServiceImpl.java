/**
 * 
 */
package com.covid.Spring.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.Spring.models.elastic.Covid19api_paysES;
import com.covid.Spring.models.mongo.Covid19api_pays;
import com.covid.Spring.repositories.elastic.Covid19api_paysESRepository;
import com.covid.Spring.repositories.mongo.Covid19api_paysRepository;
import com.covid.Spring.services.Covid19api_paysService;

/**
 * @author Thomas
 *
 */
@Service
public class Covid19api_paysServiceImpl implements Covid19api_paysService {

	
	@Autowired
	private Covid19api_paysRepository paysrepo;
	
	@Autowired
	private Covid19api_paysESRepository paysrepoES;


	@Override
	public Covid19api_paysES save(Covid19api_pays data) {
		this.paysrepo.save(data);
		//System.out.println("liste pays : " + this.paysrepo.findAll());
		Covid19api_paysES covidData = new Covid19api_paysES(data);
		//System.out.println("Service, objet ES : "+ covidData);
		return this.paysrepoES.save(covidData);
	}

}
