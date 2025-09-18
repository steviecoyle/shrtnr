package com.scoyle.shrtnr.controller;

import com.scoyle.shrtnr.request.SaveLongUrlRequest;
import com.scoyle.shrtnr.service.UrlShortenerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RequiredArgsConstructor
@RestController
@RequestMapping()
public class ShortUrlController {

    private final UrlShortenerService urlShortenerService;

    @GetMapping("/{code}")
    public ResponseEntity<String> getLongUrl(@PathVariable String code) {
        log.info("GET /{}", code);

        return new ResponseEntity<>(urlShortenerService.getLongUrlByCode(code), HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping
    public ResponseEntity<String> saveLongUrl(@RequestBody SaveLongUrlRequest saveLongUrlRequest) {
        String str = urlShortenerService.saveLogUrl(saveLongUrlRequest.getLongUrl());

        return new ResponseEntity<>(str, HttpStatus.OK);
    }
}
