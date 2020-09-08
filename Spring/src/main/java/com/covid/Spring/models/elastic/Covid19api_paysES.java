/**
 * 
 */
package com.covid.Spring.models.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.covid.Spring.models.mongo.Covid19api_pays;
import com.covid.Spring.tools.CountryNametoISO;
import com.covid.Spring.tools.PaysCsv;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(indexName = "covid19api_pays",type="covid")
@NoArgsConstructor
@AllArgsConstructor
public class Covid19api_paysES {
	@Id
	private String id;
	private double tauxDeces;
	private String pays;
	private String codePays;
	private int guerisons;
	private int infection;
	private double tauxInfection;
	private int deces;
	private String date;
	private double tauxGuerison;
	
	public Covid19api_paysES(Covid19api_pays data) {
		this.id = data.getId();
		this.tauxDeces = data.getTauxDeces();
		this.codePays = CountryNametoISO.getValueFromCsv(data.getPays(), PaysCsv.NOMPAYSFR, PaysCsv.ISOCODE2);
		this.pays = data.getPays();
		this.guerisons = data.getGuerisons();
		this.infection = data.getInfection();
		this.tauxInfection = data.getTauxInfection();
		this.deces = data.getDeces();
		this.date = data.getDate();
		this.tauxGuerison = data.getTauxGuerison();
	}

}
				