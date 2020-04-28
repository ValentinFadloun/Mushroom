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
@Document(indexName = "Resultcovid19api_allES")
@NoArgsConstructor
@AllArgsConstructor
public class Resultcovid19api_allES {
	@Id
	private String id;
	private String Country;
	private String CountryCode;
	private String Province;
	private String City;
	private String CityCode;
	private String Lat;
	private String Lon;
	private int Confirmed;
	private int Deaths;
	private int Recovered;
	private int Active;
	private String Date;
	
	public Resultcovid19api_allES(Resultcovid19api_all data) {
		this.id = data.getId();
		this.Country = data.getCountry();
		this.CountryCode = data.getCountryCode();
		this.Province = data.getProvince();
		this.City = data.getCity();
		this.CityCode = data.getCityCode();
		this.Lat = data.getLat();
		this.Lon = data.getLon();
		this.Confirmed = data.getConfirmed();
		this.Deaths = data.getDeaths();
		this.Recovered = data.getRecovered();
		this.Active = data.getActive();
		this.Date = data.getDate();
	}
}
