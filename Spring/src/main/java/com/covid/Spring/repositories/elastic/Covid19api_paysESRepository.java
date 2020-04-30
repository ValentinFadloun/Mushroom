
package com.covid.Spring.repositories.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import com.covid.Spring.models.elastic.Covid19api_paysES;


public interface Covid19api_paysESRepository extends ElasticsearchCrudRepository<Covid19api_paysES,String>{
	
}
