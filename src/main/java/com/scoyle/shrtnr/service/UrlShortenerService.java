package com.scoyle.shrtnr.service;

public interface UrlShortenerService {

    String getLongUrl(final String code);

    String saveLogUrl(final String longUrl);
}
