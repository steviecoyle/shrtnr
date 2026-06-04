package com.scoyle.shrtnr.utils;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ShortUrlGeneratorTest {

    @Test
    void verify_generated_codes() {
        Set<String> codes = new HashSet<>();

        int maxNumberOfCodes = 1000;

        for (int i = 0; i < maxNumberOfCodes; i++) {
            String code = ShortUrlGenerator.generateShortCode();
            codes.add(code);

            // assert all codes have a length of 7 characters
            assertEquals(7, code.length());

            System.out.println("No. " + i + ", code = " + code);
        }

        // assert all codes are generated
        assertEquals(maxNumberOfCodes, codes.size());
    }
}
