package com.scoyle.shrtnr.utils;

import java.util.concurrent.atomic.AtomicLong;

public class ShortUrlGenerator {

    // The single instance of the class
    private static final ShortUrlGenerator INSTANCE = new ShortUrlGenerator();

    private ShortUrlGenerator() {
        // singleton
    }

    // Public method to provide global access to the single instance
    public static ShortUrlGenerator getInstance() {
        return INSTANCE;
    }

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = ALPHABET.length();
    private static final AtomicLong counter = new AtomicLong(1000000000L); // Start from a large number

    public String encode() {
        long id = counter.getAndIncrement();
        StringBuilder sb = new StringBuilder();
        while (id > 0) {
            sb.append(ALPHABET.charAt((int) (id % BASE)));
            id /= BASE;
        }

        return sb.reverse().toString();
    }
}
