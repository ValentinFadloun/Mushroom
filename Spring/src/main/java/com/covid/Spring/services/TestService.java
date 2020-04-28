/**
 * 
 */
package com.covid.Spring.services;

import java.util.List;

import com.covid.Spring.models.elastic.TestES;
import com.covid.Spring.models.mongo.Test;

/**
 * @author Thomas
 *
 */
public interface TestService {

	public Test save(Test test);
	
	public List<TestES> saveAll();
}
