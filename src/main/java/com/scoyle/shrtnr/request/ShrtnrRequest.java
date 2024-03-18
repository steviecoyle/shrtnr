package com.scoyle.shrtnr.request;

public class ShrtnrRequest {
	
	private String longUrl;
	
	public ShrtnrRequest() {
		// empty constructor
	}
	
	public ShrtnrRequest(String longUrl) {
		super();
		this.longUrl = longUrl;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

}
