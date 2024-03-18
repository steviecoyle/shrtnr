package com.scoyle.shrtnr.service;

public interface DbService {
	
	public void saveUrl(String shortUrl, String longUrl);
	
	public String getLongUrl(String shortUrl);
}
