/**
 * 
 */
package com.covid.Spring.controllers;

import java.util.List;

import com.covid.Spring.models.mongo.Resultcovid19api_all;

/**
 * @author Thomas
 *
 */
public class WrapperResultcovid19api_all {

	    private List<Resultcovid19api_all> data;

	    /**
	     * @return the persons
	     */
	    public List<Resultcovid19api_all> getResultcovid19sapi_all() {
	        return data;
	    }

	    /**
	     * @param persons the persons to set
	     */
	    public void setPersons(List<Resultcovid19api_all> data) {
	        this.data = data;
	    }
	
}
