package com.scoyle.shrtnr.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ShrtUrlGenerator {
	
	// Best placed in a configuration file
	public static final int SHORT_URL_LENGTH = 7;
	
	private ShrtUrlGenerator() {
		// empty constructor
	}
	
	public static String generateShrtUrl(String longUrl) {
		
		String encodedUrl = encodeUrl(longUrl + getAdditionalChars(longUrl));
		return encodedUrl.substring((encodedUrl.length() - SHORT_URL_LENGTH), (encodedUrl.length()));
	}

	private static String getAdditionalChars(String longUrl) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 20; i++) {
			int random = (int)(Math.random() * longUrl.length());
			sb.append(longUrl.charAt(random));
		}
		
		return sb.toString();
	}
	
	private static String encodeUrl(final String url) {
		String encodedUrl = Base64.getUrlEncoder().encodeToString(url.getBytes(StandardCharsets.UTF_8));
		return encodedUrl.replace("=", "").trim();
	}
}
