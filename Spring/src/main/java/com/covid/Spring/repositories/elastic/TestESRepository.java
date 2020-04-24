package com.covid.Spring.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

import com.covid.Spring.models.elastic.TestES;


public interface TestESRepository extends ElasticsearchCrudRepository<TestES,String>{

}
