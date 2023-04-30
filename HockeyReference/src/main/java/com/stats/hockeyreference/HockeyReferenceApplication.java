package com.stats.hockeyreference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stats.hockeyreference.scraper.HockeyReferenceScraper;

@SpringBootApplication
public class HockeyReferenceApplication {

	public static void main(String... args) {
		SpringApplication.run(HockeyReferenceApplication.class, args);
		
		HockeyReferenceScraper.scrapeFiles();
	}

}
