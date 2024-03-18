package com.scoyle.shrtnr.service;

import java.sql.SQLException;

import com.scoyle.shrtnr.request.ShrtnrRequest;

public class ShrtnrServiceImpl implements ShrtnrService {
	
	private DbService dbService;
	
	public ShrtnrServiceImpl() {
		try {
			dbService = new DbServiceImpl();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getLongUrl(String shortUrl) {
		return dbService.getLongUrl(shortUrl);
	}
	
	@Override
	public String generateShrtUrl(ShrtnrRequest request) {
		String shortUrl = ShrtUrlGenerator.generateShrtUrl(request.getLongUrl());
		
		if (dbService != null) {
			dbService.saveUrl(shortUrl, request.getLongUrl());
			
			return shortUrl;
		}
		
		return "";
	}
}
