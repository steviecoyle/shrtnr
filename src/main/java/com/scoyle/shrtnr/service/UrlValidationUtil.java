package com.scoyle.shrtnr.service;

import java.util.regex.Pattern;

public class UrlValidationUtil {
	
	private final static String URL_REGEX = "^https?:\\/\\/(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$";
	
	private UrlValidationUtil() {
		
	}
	
	public static boolean isValidRequest(String url) {
		if (url == null || url == "") {
			return false;
		}
		
		return Pattern.compile(URL_REGEX)
	               .matcher(url)
	               .find();
	}
}
