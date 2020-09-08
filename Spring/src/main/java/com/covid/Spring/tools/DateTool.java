package com.covid.Spring.tools;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTool {

	public static String getCurrentDateMinusOneDay() {
		String currentDate = ZonedDateTime.now( ZoneId.of( "Europe/Paris" ) )
		        .truncatedTo( ChronoUnit.MINUTES ).minusDays(1).withHour(0).withMinute(0)
		        .format( DateTimeFormatter.ISO_LOCAL_DATE_TIME );
		return currentDate;
	}
}
