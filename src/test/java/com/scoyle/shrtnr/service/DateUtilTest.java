package com.scoyle.shrtnr.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {
	
	private Date shortUrlCreatedDate;
	private final int SEVEN_DAYS_HOURS = 168;
	
	@Test
	public void date_within_retention_days_should_assert_false() {
		shortUrlCreatedDate = todaysDateMinusDays(1);
		
		assertFalse(DateUtil.shouldDeleteShortUrl(shortUrlCreatedDate));
	}
	
	@Test
	public void date_older_than_retention_days_should_assert_false() {
		shortUrlCreatedDate = todaysDateMinusDays(8);
		
		assertTrue(DateUtil.shouldDeleteShortUrl(shortUrlCreatedDate));
	}
	
	@Test
	public void date_within_retention_day_by_hours_should_assert_false() {
		shortUrlCreatedDate = todaysDateMinusHours((SEVEN_DAYS_HOURS - 2));
		
		assertFalse(DateUtil.shouldDeleteShortUrl(shortUrlCreatedDate));
	}
	
	@Test
	public void date_older_than_retention_day_by_hours_should_assert_false() {
		shortUrlCreatedDate = todaysDateMinusHours((SEVEN_DAYS_HOURS + 2));
		
		assertTrue(DateUtil.shouldDeleteShortUrl(shortUrlCreatedDate));
	}

	private Date todaysDateMinusDays(int minusDays) {
		Calendar cal = Calendar.getInstance();
		// remove next line if you're always using the current time.
		cal.setTime(new Date());
		cal.add(Calendar.DAY_OF_MONTH, (- minusDays));
		return cal.getTime();
	}
	
	private Date todaysDateMinusHours(int minusHours) {
		Calendar cal = Calendar.getInstance();
		// remove next line if you're always using the current time.
		cal.setTime(new Date());
		cal.add(Calendar.HOUR, (- minusHours));
		return cal.getTime();
	}
}
