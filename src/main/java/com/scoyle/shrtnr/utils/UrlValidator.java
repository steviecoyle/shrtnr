package com.scoyle.shrtnr.utils;

import java.util.regex.Pattern;

public class UrlValidator {

    private static final String URL_REGEX = "^https?:\\/\\/(?:www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b(?:[-a-zA-Z0-9()@:%_\\+.~#?&\\/=]*)$";

    private UrlValidator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean isValidRequest(String url) {
        if (url == null || url.isEmpty()) {
            return false;
        }

        return Pattern.compile(URL_REGEX)
                .matcher(url)
                .find();
    }
}
