/**
 * 
 */
package com.covid.Spring.models.mongo;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection ="reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resultcovid19api_all {
	@Id
	private String id;
	private String country;
	private String countryCode;
	private String province;
	private String city;
	private String cityCode;
	private String lat;
	private String lon;
	private int confirmed;
	private int deaths;
	private int recovered;
	private int active;
	private String date;
	
}
