package com.scoyle.shrtnr.utils;

import java.security.SecureRandom;

public class ShortUrlGenerator {

    private ShortUrlGenerator() {
        // singleton
    }

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * Generates a random alphanumeric code of a specific length.
     * @return A random String
     */
    public static String generateShortCode() {

        StringBuilder code = new StringBuilder(7);
        for (int i = 0; i < 7; i++) {
            int randomIndex = RANDOM.nextInt(ALPHABET.length());
            code.append(ALPHABET.charAt(randomIndex));
        }

        return code.toString();
    }
}
