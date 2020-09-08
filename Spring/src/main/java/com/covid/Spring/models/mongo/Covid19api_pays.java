/**
 * 
 */
package com.covid.Spring.models.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "evolData")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Covid19api_pays {

	@Id
	private String id;
	private double tauxDeces;
	private String pays;
	private int guerisons;
	private int infection;
	private double tauxInfection;
	private int deces;
	private String date;
	private double tauxGuerison;

}
