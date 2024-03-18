package com.scoyle.shrtnr.service;

import com.scoyle.shrtnr.request.ShrtnrRequest;

public interface ShrtnrService {
	
	public String getLongUrl(String shortUrl);
	
	public String generateShrtUrl(ShrtnrRequest request);
}
