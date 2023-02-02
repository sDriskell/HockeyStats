package process;

import java.io.FileWriter;
import java.io.IOException;

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

    private static final String TEAM_STANDINGS =
            "https://www.hockey-reference.com/leagues/NHL_2023_standings.html#site_menu_link";
    private static final String SKATER_BASIC_STATS =
            "https://www.hockey-reference.com/leagues/NHL_2023_skaters.html";
    private static final String SKATER_ADVANCED_STATS =
            "https://www.hockey-reference.com/leagues/NHL_2023_skaters-advanced.html";
    private static final String GOALIE_STATS =
            "https://www.hockey-reference.com/leagues/NHL_2023_goalies.html";

    private static final String TEAM_STANDINGS_FILE_NAME = "nhlTeamStandings.csv";
    private static final String SKATER_BASIC_STATS_FILE_NAME = "nhlSkatersBasic.csv";
    private static final String SKATER_ADVANCED_STATS_FILE_NAME = "nhlSkatersAdvanced.csv";
    private static final String GOALIE_STATS_FILE_NAME = "nhlGoalies.csv";

    private static final String TEAM_ELEMENT_ID = "expanded_standings";
    private static final String SKATER_BASIC_ELEMENT_ID = "all_stats";
    private static final String SKATER_ADVANCED_ELEMENT_ID = "all_stats_adv_rs";
    private static final String GOALIE_ELEMENT_ID = "div_stats";
    
    public static void scrapeFiles() {
        try {
            createCsvFile(TEAM_STANDINGS, TEAM_ELEMENT_ID, TEAM_STANDINGS_FILE_NAME);

            createCsvFile(SKATER_BASIC_STATS, SKATER_BASIC_ELEMENT_ID,
                    SKATER_BASIC_STATS_FILE_NAME);

            createCsvFile(SKATER_ADVANCED_STATS, SKATER_ADVANCED_ELEMENT_ID,
                    SKATER_ADVANCED_STATS_FILE_NAME);

            createCsvFile(GOALIE_STATS, GOALIE_ELEMENT_ID, GOALIE_STATS_FILE_NAME);
        }
        catch (IOException e) {
            LOG.error("Exception occurred while scraping site(s).");
        }
        LOG.info("Hockey Reference Site Scraped.");
    }

    private static void createCsvFile(String url, String elementId, String fileName)
            throws IOException {
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
