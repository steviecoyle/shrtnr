package com.scoyle.shrtnr.service;

public interface UrlShortenerService {

    String getLongUrlByCode(final String code);

    String saveLogUrl(final String longUrl);
}
