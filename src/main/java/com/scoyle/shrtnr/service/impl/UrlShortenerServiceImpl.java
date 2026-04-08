package com.scoyle.shrtnr.service.impl;

import com.scoyle.shrtnr.persistence.entity.ShortUrlEntity;
import com.scoyle.shrtnr.persistence.repository.ShortUrlRepository;
import com.scoyle.shrtnr.service.UrlShortenerService;
import com.scoyle.shrtnr.utils.ShortUrlGenerator;
import com.scoyle.shrtnr.utils.UrlValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Log4j2
@Service
class UrlShortenerServiceImpl implements UrlShortenerService {

    private final ShortUrlRepository shortUrlRepository;

    @Override
    public String getLongUrlByCode(final String code) {
        return "";
    }

    @Override
    public String saveLogUrl(final String longUrl) {

        // if NOT valid
        if (!UrlValidator.isValidRequest(longUrl)) {
            log.error("Invalid URL");
            return null;
        }

        String code = ShortUrlGenerator.generateShortCode();

        ShortUrlEntity entity = new ShortUrlEntity();
        entity.setCode(code);
        entity.setLongUrl(longUrl);
        entity.setCreated(new Date());

        shortUrlRepository.save(entity);

        return code;
    }
}
