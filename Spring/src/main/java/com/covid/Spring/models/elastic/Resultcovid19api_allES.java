/**
 * 
 */
package com.covid.Spring.models.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.covid.Spring.models.mongo.Resultcovid19api_all;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Document(indexName = "covid19api_alles")
@NoArgsConstructor
@AllArgsConstructor
public class Resultcovid19api_allES {
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
	
	public Resultcovid19api_allES(Resultcovid19api_all data) {
		this.id = data.getId();
		this.country = data.getCountry();
		this.countryCode = data.getCountryCode();
		this.province = data.getProvince();
		this.city = data.getCity();
		this.cityCode = data.getCityCode();
		this.lat = data.getLat();
		this.lon = data.getLon();
		this.confirmed = data.getConfirmed();
		this.deaths = data.getDeaths();
		this.recovered = data.getRecovered();
		this.active = data.getActive();
		this.date = data.getDate();
	}
}