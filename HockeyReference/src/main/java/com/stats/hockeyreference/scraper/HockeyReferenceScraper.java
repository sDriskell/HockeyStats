package com.stats.hockeyreference.scraper;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HockeyReferenceScraper {
    private static final Logger LOG = LogManager.getLogger(HockeyReferenceScraper.class);

    private static final String TABLE_ROW = "tr";
    private static final String TABLE_CELL = "td";

    private static final String TEAM_STANDINGS = "https://www.hockey-reference.com/leagues/NHL_%d_standings.html#site_menu_link";
    private static final String SKATER_BASIC_STATS = "https://www.hockey-reference.com/leagues/NHL_%d_skaters.html";
    private static final String SKATER_ADVANCED_STATS = "https://www.hockey-reference.com/leagues/NHL_%d_skaters-advanced.html";
    private static final String GOALIE_STATS = "https://www.hockey-reference.com/leagues/NHL_%d_goalies.html";

    private static final String TEAM_STANDINGS_FILE_NAME = "nhlTeamStandings.csv";
    private static final String SKATER_BASIC_STATS_FILE_NAME = "nhlSkatersBasic.csv";
    private static final String SKATER_ADVANCED_STATS_FILE_NAME = "nhlSkatersAdvanced.csv";
    private static final String GOALIE_STATS_FILE_NAME = "nhlGoalies.csv";

    private static final String TEAM_ELEMENT_ID = "expanded_standings";
    private static final String SKATER_BASIC_ELEMENT_ID = "all_stats";
    private static final String SKATER_ADVANCED_ELEMENT_ID = "all_stats_adv_rs";
    private static final String GOALIE_ELEMENT_ID = "div_stats";

    public static void scrapeFiles() {
        Scanner scanner = new Scanner(System.in);
        LOG.info("Enter a year: ");
        
        int year;
        
        try {
            year = scanner.nextInt();
        }
        catch (Exception e){
            LOG.warn("Incorrect year entry.  Defaulting to current year");
            year = Year.now().getValue();
        }
        
        try {
            createCsvFile(String.format(TEAM_STANDINGS, year), TEAM_ELEMENT_ID, TEAM_STANDINGS_FILE_NAME);

            createCsvFile(String.format(SKATER_BASIC_STATS, year), SKATER_BASIC_ELEMENT_ID, SKATER_BASIC_STATS_FILE_NAME);

            createCsvFile(String.format(SKATER_ADVANCED_STATS, year), SKATER_ADVANCED_ELEMENT_ID, SKATER_ADVANCED_STATS_FILE_NAME);

            createCsvFile(String.format(GOALIE_STATS, year), GOALIE_ELEMENT_ID, GOALIE_STATS_FILE_NAME);
        }
        catch (IOException e) {
            LOG.error("Exception occurred while scraping site(s).");
        }
        LOG.info("Hockey Reference Site Scraped.");
        scanner.close();
    }

    private static void createCsvFile(String url, String elementId, String fileName) throws IOException {
        Document doc = Jsoup.connect(url).get();

        try (FileWriter csvWriter = new FileWriter(fileName)) {
            for (Element row : doc.getElementById(elementId).getAllElements()) {
                Elements cells = row.getElementsByTag(TABLE_CELL);

                for (Element cell : cells) {
                    if (TABLE_ROW.equals(row.tagName())) {
                        csvWriter.write("\n");
                        break;
                    }
                    else {
                        csvWriter.write(cell.text().concat(","));
                    }
                }
            }
        }
        catch (IOException e) {
            LOG.error("Exception occurred while writing to csv file for: {}", url);
        }
    }
}