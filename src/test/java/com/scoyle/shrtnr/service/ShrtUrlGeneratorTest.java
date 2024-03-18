package com.scoyle.shrtnr.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ShrtUrlGeneratorTest {
	
	private String longUrl;
	
	@Before
	public void setup() {
		longUrl = "https://owasp.org/www-project-top-ten/";
	}
	
	@Test
	public void short_url_equals_preset_chars_length() {
		assertTrue(ShrtUrlGenerator.generateShrtUrl(longUrl).length() == ShrtUrlGenerator.SHORT_URL_LENGTH);
	}
	
	@Test
	public void verify_short_url_does_return_same_short_url_when_called_with_same_long_url() {
		String firstShrtUrl = ShrtUrlGenerator.generateShrtUrl(longUrl);
		
		String secondShrtUrl = ShrtUrlGenerator.generateShrtUrl(longUrl);
	
		assertFalse(firstShrtUrl.equals(secondShrtUrl));
	}

	@Test
	public void short_url_not_equal_to_long_url_multiple_tries() {
		for (int i = 0; i < 2000; i++) {
			verify_short_url_does_return_same_short_url_when_called_with_same_long_url();
		}
	}
}
