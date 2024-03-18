package com.scoyle.shrtnr.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UrlValidationUtilTest {
	
	private final String URL_STRING_FORMAT = "https://www.go%sogle.com/";
	private String[] INVALID_CHARS = {"<", ">", "'", "€", " ", "{", "}", "[", "]"};
	
	@Test
	public void verify_null_long_url_is_not_valid() {
		
		assertFalse(UrlValidationUtil.isValidRequest(null));
	}
	
	@Test
	public void verify_empty_long_url_is_not_valid() {
		
		assertFalse(UrlValidationUtil.isValidRequest(""));
	}
	
	@Test
	public void verify_empty_with_space_long_url_is_not_valid() {
		
		assertFalse(UrlValidationUtil.isValidRequest(" "));
	}
	
	@Test
	public void verify_greater_than_in_long_url_is_not_valid() {
		for (String value : INVALID_CHARS) {
			assertFalse(UrlValidationUtil.isValidRequest(String.format(URL_STRING_FORMAT, value)));
		}
	}
	
	@Test
	public void verify_valid_urls_are_valid() {
		
		for (String url : getWebUrlList()) {
			assertTrue(UrlValidationUtil.isValidRequest(url));
		}
	}
	
	private List<String> getWebUrlList() {
		List<String> urls = new ArrayList<String>();
		urls.add("https://sitechecker.pro/wp-content/uploads/2020/11/Canonical-to-non-200.png");
		urls.add("https://uibakery.io/regex-library/url-regex-java");
		urls.add("https://sitechecker.pro/site-audit-issues/canonical-to-non-200/");
		urls.add("https://en.wikipedia.org/wiki/The_Simpsons");
		urls.add("https://www.independent.co.uk/news/uk/politics/rwanda-bill-afghan-rishi-sunak-boats-b2514057.html");
		urls.add("https://www.bbc.co.uk/news/world-europe-68589594");
		urls.add("https://www.ncsc.gov.uk/section/about-ncsc/what-is-cyber-security");
		urls.add("https://www.kaspersky.com/resource-center/definitions/what-is-cyber-security");
		urls.add("https://www.google.com/search?q=cyber+security&rlz=1C5CHFA_enGB1083GB1084&oq=cyber+&gs_lcrp=EgZjaHJvbWUqDAgBEAAYQxiABBiKBTIGCAAQRRg5MgwIARAAGEMYgAQYigUyDAgCEAAYQxiABBiKBTIMCAMQABhDGIAEGIoFMgwIBBAAGEMYgAQYigUyBggFEEUYPTIGCAYQRRg9MgYIBxBFGD3SAQg1ODcxajBqNKgCALACAA&sourceid=chrome&ie=UTF-8");
		urls.add("https://www.apple.com/uk/store?afid=p238%7Cs4Xr4OfDd-dc_mtid_187079nc38483_pcrid_675896380253_pgrid_15144742573_pntwk_g_pchan__pexid__&cid=aos-uk-kwgo-brand--slid--bran-product-");
		urls.add("https://www.apple.com/uk/");
		urls.add("https://uk.webuy.com/product-detail/?id=5026555302593&categoryName=playstation2-games&superCatName=gaming&title=&queryID=325c0fb47f9c989f77c3cd541ce78dda&position=2");
		urls.add("https://www.ebay.co.uk/itm/375195454638?_trkparms=amclksrc%3DITM%26aid%3D777008%26algo%3DPERSONAL.TOPIC%26ao%3D1%26asc%3D20230823115209%26meid%3D04c745f0978e4adab4359e21a4b36de0%26pid%3D101800%26rk%3D1%26rkt%3D1%26itm%3D375195454638%26pmt%3D0%26noa%3D1%26pg%3D4375194%26algv%3DRecentlyViewedItemsV2SignedOut&_trksid=p4375194.c101800.m5481&_trkparms=parentrq%3A4e92565718e0a8d792803f1cfffd6428%7Cpageci%3A47e31c9c-e4af-11ee-b9d7-b2d137e62932%7Ciid%3A1%7Cvlpname%3Avlp_homepage");
		urls.add("https://www.ebay.co.uk/");
		urls.add("https://pixabay.com/images/search/cat/");
		urls.add("https://github.com/JohnAntonioCollins/MicBotServer/tree/master/mic-bot");
		
		return urls;
	}
}
