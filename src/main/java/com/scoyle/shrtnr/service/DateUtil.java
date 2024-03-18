package com.scoyle.shrtnr.service;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	// This would be in a configuration file
	public static int SHORT_URL_RETENTION_DAYS = 7;
	
	private DateUtil() {
		
	}
	
	public static boolean shouldDeleteShortUrl(Date createdDate) {
		Calendar calSevenDaysBefore = getRetentionTimeFrame();
		
		Calendar urlCreatedCal = convertDateToCalendar(createdDate);
		
		return urlCreatedCal.before(calSevenDaysBefore);
	}
	
	private static Calendar getRetentionTimeFrame() {
		Calendar calSevenDaysBefore = Calendar.getInstance();
		calSevenDaysBefore.add(Calendar.DAY_OF_MONTH, (- SHORT_URL_RETENTION_DAYS));
		
		return calSevenDaysBefore;
	}
	
	private static Calendar convertDateToCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		
		return cal;
	}
}
