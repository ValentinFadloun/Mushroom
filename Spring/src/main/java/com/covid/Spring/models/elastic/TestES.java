package com.covid.Spring.models.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.covid.Spring.models.mongo.Test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(indexName = "test")
@NoArgsConstructor
@AllArgsConstructor
public class TestES {
	@Id
	private String id;
	private String pays;
	private int deaths;
	private int recovered;
	private int safes;

	public TestES(Test test) {
		this.id = test.getId();
		this.pays = test.getPays();
		this.deaths = test.getDeaths();
		this.recovered = test.getRecovered();
		this.safes = test.getSafes();
	}

}
