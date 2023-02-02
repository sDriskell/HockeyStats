package process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import stats.BasicPlayerStats;
import stats.SkaterStats;

/**
 * The processor object will handle the logic and manipulation of the
 * statistical data derived from the scraper class.
 * 
 * @author sldri
 *
 */
public class Processor {
    private static final Logger logger = LogManager.getLogger(Processor.class);

    private List<List<String>> rawSkatersBasicStats = new ArrayList<>();
    private List<List<String>> rawSkaterAdvancedStats = new ArrayList<>();
    private List<List<String>> rawLeagueStandings = new ArrayList<>();
    private List<List<String>> rawGoalieStatistics = new ArrayList<>();

    private List<BasicPlayerStats> playerObjects = new ArrayList<>();
    private SkaterStats skaterStats;

    private Map<String, String> teamNamesAndAbbv = new HashMap<>();
    private ProcessCsvFile processCsvFile = new ProcessCsvFile();

    /**
     * Constructor class initiates the process for consuming csv file with player
     * stats and assigns them to their team.
     * 
     * @throws IOException if file is not present
     */
    public Processor() throws IOException {
        HockeyReferenceScraper.scrapeFiles();

        rawSkatersBasicStats = createListFromCsvFile("nhlSkatersBasic.csv");
        rawLeagueStandings = createListFromCsvFile("nhlTeamStandings.csv");
        rawSkaterAdvancedStats = createListFromCsvFile("nhlSkatersAdvanced.csv");
        rawGoalieStatistics = createListFromCsvFile("nhlGoalies.csv");

        logger.info("Loading settings");
        // TODO: Create Settings

        logger.info("Creating skater objects.");
        createPlayerObjects(rawSkatersBasicStats);

        logger.info("Assigning players to teams.");
        skaterStats = new SkaterStats(playerObjects);
    }

    /**
     * Runs process to create the statistical data from the csv file identified in
     * the fileName argument.
     * 
     * @param fileName name of the csv file being used to create a List of file's
     *                 statistics
     * @return a List<List<String>> object with ingested statistical data read from
     *         csv fileName
     * @throws IOException if file is not present
     */
    private List<List<String>> createListFromCsvFile(String fileName) throws IOException {
        logger.info("Processing file: {}", fileName);

        List<List<String>> tempStats = new ArrayList<>();

        tempStats = processCsvFile.processCsvFile(fileName);
        // TODO: Clean up scraper to omit ugly, first line entry in csv files
        tempStats.remove(0); // Remove excess header line
        return tempStats;
    }

    /**
     * Creates a map from file name argument of team abbv name and full team name.
     * 
     * @param fileName name of file with team names being created
     * @return Map<String, String> where key: abbv. team name and value: full team
     *         name
     * @throws IOException throws if file name not found
     */
    private Map<String, String> loadTeamNames(String fileName) throws IOException {
        return processCsvFile.generateTeamMap(fileName);
    }

    /**
     * Factory method making player and stats object(s).
     * 
     * @param argNhlPlayerStats is a list of player information
     * @return NhlPlayerStats object with the arguments values added
     */
    private BasicPlayerStats createPlayerStatObject(List<String> argNhlPlayerStats) {
        return new BasicPlayerStats(argNhlPlayerStats);
    }

    /**
     * Handles going through list of players and calling factory method for creating
     * player object(s).
     * 
     * @param nhlPlayersStats is a list of players with a list of player stats.
     */
    private void createPlayerObjects(List<List<String>> nhlPlayersStats) {
        logger.info("Creating player objects using parsed csv file.");
        for (List<String> player : nhlPlayersStats) {
            playerObjects.add(createPlayerStatObject(player));
        }
    }

    public SkaterStats getLeagueStats() {
        return skaterStats;
    }
}
