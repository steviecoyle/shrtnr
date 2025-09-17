package com.scoyle.shrtnr.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UrlValidatorTest {

    @Test
    void verify_empty_url_returns_false() {
        assertFalse(UrlValidator.isValidRequest(""));
    }

    @Test
    void verify_null_url_returns_false() {
        assertFalse(UrlValidator.isValidRequest(null));
    }

    @Test
    void verify_range_of_valid_urls_return_true() {
        for (String url: urls) {
            boolean isTrue = UrlValidator.isValidRequest(url);
            if (!isTrue) {
                System.out.println("URL " + url + " has failed validation");
            }

            assertTrue(isTrue);
        }
    }

    private final List<String> urls = Arrays.asList(
            "http://www.example.com",
            "https://www.example.com",
            "https://www.example.ai",
            "https://example.com",
            "https://www.example-website.com",
            "https://www.example_website.com",
            "https://opensource.com/article/23/6/new-developments-opensourcecom",
            "https://simply-docs.co.uk/Content/Download?documentID=CfDJ8P--n9qqBLtHuES0rjrwm6FXJGpA34YsoujbJxyOn0cAAxp2e8O5_kJjFFxSZwaQaZRXOmj3DPAx9c-y3EAJ3m8TlMKOjaVDXB4yX32bmRIqE74spyLERn-jY5GPdX3POg",
            "https://www.ebay.co.uk/itm/136452982423?_trkparms=amclksrc%3DITM%26aid%3D777008%26algo%3DPERSONAL.TOPIC%26ao%3D1%26asc%3D20240603120050%26meid%3D39efd2553e944222b400c4dc692b669c%26pid%3D102175%26rk%3D1%26rkt%3D1%26itm%3D136452982423%26pmt%3D0%26noa%3D1%26pg%3D4375194%26algv%3DNoSignalMostSearched%26brand%3DNike&_trksid=p4375194.c102175.m166538&_trkparms=parentrq%3A59e3348d1990a6718ce4ef9bfff77dee%7Cpageci%3A4ec76996-9419-11f0-b8c0-0a64e77f2af4%7Ciid%3A1%7Cvlpname%3Avlp_homepage",
            "https://www.google.com/imgres?q=manchester%20united%20f.c.&imgurl=https%3A%2F%2Fupload.wikimedia.org%2Fwikipedia%2Fen%2Fthumb%2F7%2F7a%2FManchester_United_FC_crest.svg%2F1184px-Manchester_United_FC_crest.svg.png&imgrefurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FManchester_United_F.C.&docid=HSrEjIMMKy9whM&tbnid=DhQGEjNQO44B2M&vet=12ahUKEwjKrpn-8uCPAxV4XEEAHYKYOtwQM3oECCAQAA..i&w=1184&h=1200&hcb=2&ved=2ahUKEwjKrpn-8uCPAxV4XEEAHYKYOtwQM3oECCAQAA",
            "https://refactoring.guru/design-patterns/factory-method/java/example",
            "https://stackoverflow.com/questions/13318733/get-closest-value-to-a-number-in-array",
            "https://www.youtube.com/watch?v=2bW3HuaAUcY",
            "https://stangarfield.medium.com/personal-knowledge-management-how-to-do-it-with-25-resources-and-10-books-on-pkm-2adce0e1d05c",
            "https://x.com/helldivers2/status/1968323941853704534"
    );
}
