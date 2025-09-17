package com.scoyle.shrtnr.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ShortUrlGeneratorTest {

    @Test
    void verify_generated_code_is_not_null() {
        ShortUrlGenerator generator = ShortUrlGenerator.getInstance();

        String code = generator.encode();

        assertNotNull(code);
        System.out.println(code);
    }

    @Test
    void verify_generated_codes() {
        Set<String> codes = new HashSet<>();
        ShortUrlGenerator generator = ShortUrlGenerator.getInstance();

        for (int i = 0; i < 100; i++) {
            String code = generator.encode();
            codes.add(code);
            System.out.println("No. " + i + ", code = " + code);
        }

        assertEquals(100, codes.size());
    }
}
