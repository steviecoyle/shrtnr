package com.scoyle.shrtnr.service;

public interface UrlShortenerService {

    String getLongUrl(final String shortUrl);

    String saveLogUrl(final String longUrl);
}
