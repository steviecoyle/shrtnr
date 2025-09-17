package com.scoyle.shrtnr.service.impl;

import com.scoyle.shrtnr.persistence.repository.ShortUrlRepository;
import com.scoyle.shrtnr.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Log4j2
@Service
class UrlShortenerServiceImpl implements UrlShortenerService {

    private final ShortUrlRepository shortUrlRepository;

    @Override
    public String getLongUrl(final String code) {
        return "";
    }

    @Override
    public String saveLogUrl(final String longUrl) {
        return "";
    }
}
