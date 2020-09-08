/**

 * 
 */
package com.covid.Spring.tools;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class CountryNametoISO {

	String pathToCsv = "";

	private static String csvFile = "C:\\Users\\Thomas\\git\\Mushroom\\DATA\\sql-pays.csv";
	BufferedReader br = null;
	private static String COMMA_DELIMITER = ";";

	public static List<List<String>> readCsvToArray() {

		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] values = line.split(COMMA_DELIMITER);
				records.add(Arrays.asList(values));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return records;

	}

	public static String getValueFromCsv(String value,PaysCsv from,PaysCsv to) {
		Stream<List<String>> flux = readCsvToArray().stream();
		Optional<List<String>> result =
				flux.filter(pays -> pays.get(from.indice).equalsIgnoreCase(value))
			    .findFirst();
		if(result.isPresent()) return result.get().get(to.indice);
		return "";
		
	}

}
