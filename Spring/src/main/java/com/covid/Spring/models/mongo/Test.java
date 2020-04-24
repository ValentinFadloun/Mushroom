/**
 * 
 */
package com.covid.Spring.models.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {
	@Id
	private String id;
	private String pays;
	private int deaths;
	private int recovered;
	private int safes;
}
