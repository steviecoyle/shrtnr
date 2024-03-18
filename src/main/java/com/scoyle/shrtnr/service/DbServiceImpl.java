package com.scoyle.shrtnr.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

public class DbServiceImpl implements DbService {
	
	private final String FETCH_QUERY = "SELECT * FROM ShortUrls WHERE shortUrl = ?";
	private final String INSERT_QUERY = "insert into ShortUrls(shortUrl, longUrl) values(?, ?)";
	private final String DELETE_QUERY = "DELETE FROM ShortUrls WHERE shortUrl = ?";
	
	private Connection dbConnection;
	
	public DbServiceImpl() throws ClassNotFoundException, SQLException {
		establishDbConnection();
	}

	@Override
	public void saveUrl(String shortUrl, String longUrl) {
		try {
			PreparedStatement ps = dbConnection.prepareStatement(INSERT_QUERY);
			ps.setString(1, shortUrl);
			ps.setString(2, longUrl);
			
			ps.execute();
		} catch(Exception ex) {
			System.out.println("UNABLE TO SAVE");
			System.out.println(ex.getLocalizedMessage());
		}
	}
	
	@Override
	public String getLongUrl(String shortUrl) {		
		String myUrl = "https://www.vizion.com/wp-content/uploads/2018/09/shutterstock_479042983.jpg";
		
		try {
			PreparedStatement ps = dbConnection.prepareStatement(FETCH_QUERY);
			ps.setString(1, shortUrl);
			ResultSet result = ps.executeQuery();
			
			while (result.next()) {
				Date createdDate = result.getDate("created");
				if (DateUtil.shouldDeleteShortUrl(createdDate)) {
					deleteShortUrl(shortUrl);
					continue;
				}
				
				myUrl = result.getString("longUrl");
			}
		} catch (Exception ex) {
			System.out.println("UNABLE TO FETCH");
			System.out.println(ex.getLocalizedMessage());
		}
		
		return myUrl;
	}
	
	private void establishDbConnection() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:10001/shrtnrdb";
		String user = "root";
		String pass = "coyle";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		dbConnection = DriverManager.getConnection(url, user, pass);
	}
	
	private void deleteShortUrl(String shortUrl) {
		try {
			PreparedStatement ps = dbConnection.prepareStatement(DELETE_QUERY);
			ps.setString(1, shortUrl);
			ps.execute();
			
		} catch (SQLException ex) {
			System.out.println("UNABLE TO DELETE");
			System.out.println(ex.getLocalizedMessage());
		}
		
	}
}
