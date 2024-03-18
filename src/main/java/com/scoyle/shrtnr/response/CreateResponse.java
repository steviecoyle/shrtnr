package com.scoyle.shrtnr.response;

public class CreateResponse {
	
	public CreateResponse() {
		// empty constructor
	}
	
	public CreateResponse(String shortUrl) {
		super();
		this.shortUrl = shortUrl;
	}
	
	private String shortUrl;

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	
	
}
