/**
 * 
 */
package com.covid.Spring.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.covid.Spring.models.elastic.Resultcovid19api_allES;

public interface Resultcovid19api_allESRepository extends ElasticsearchCrudRepository<Resultcovid19api_allES,String>{

}
