/**
 * 
 */
package com.covid.Spring.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid.Spring.models.mongo.Covid19api_pays;

public interface Covid19api_paysRepository  extends MongoRepository<Covid19api_pays, String> {

}
