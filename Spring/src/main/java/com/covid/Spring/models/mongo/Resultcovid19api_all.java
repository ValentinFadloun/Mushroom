/**
 * 
 */
package com.covid.Spring.models.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document()
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resultcovid19api_all {
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
}
