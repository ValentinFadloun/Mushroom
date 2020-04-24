/**
 * 
 */
package com.covid.Spring.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.covid.Spring.models.mongo.Test;

public interface TestRepository  extends MongoRepository<Test, String> {

}
