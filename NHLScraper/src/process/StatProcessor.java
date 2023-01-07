package process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.NhlScraper;
import stats.PlayerStats;
import stats.LeagueStats;

/**
 * The processor object will handle the logic and manipulation of the
 * nhlPlayerObjects list.
 * 
 * @author sldri
 *
 */
public class StatProcessor {
    private static final Logger logger = LogManager.getLogger(StatProcessor.class);

    private List<List<String>> rawAllPlayerStats;

    private List<PlayerStats> playerObjects = new ArrayList<>();
    private List<String> playerStatsHeader;
    private LeagueStats leagueStats;
    
    private List<List<String>> rawDraftPlayers;

    /**
     * Constructor class initiates the process for consuming csv file with player
     * stats and assigns them to their team.
     * 
     * @throws IOException
     */
    public StatProcessor() throws IOException {
        logger.info("Processing NHL stats file.");
        rawAllPlayerStats = new ArrayList<>();
        ProcessCsvFile processCsvFile = new ProcessCsvFile();
        rawAllPlayerStats = processCsvFile.processCsvFile(rawAllPlayerStats, "nhlstats.csv");

        logger.info("Populating players and stats.");
        rawAllPlayerStats.remove(0);  // Excess header row removed
        playerStatsHeader = rawAllPlayerStats.remove(0); // Pops off header row
        createPlayerObjects(rawAllPlayerStats);
        
        logger.info("Assigning players to teams.");
        leagueStats = new LeagueStats(playerObjects);
        
        logger.info("Processing NHL draft team.");
        rawDraftPlayers = new ArrayList<>();
        rawDraftPlayers = processCsvFile.processCsvFile(rawDraftPlayers, "nhldraft.csv");
    }
 
    /**
     * Factory method making player and stats object(s).
     * 
     * @param argNhlPlayerStats is a list of player information
     * @return NhlPlayerStats object with the arguments values added
     */
    private PlayerStats createPlayerStatObject(List<String> argNhlPlayerStats) {
        return new PlayerStats(argNhlPlayerStats);
    }

    /**
     * Handles going through list of players and calling factory method for creating player object(s).
     * 
     * @param argNhlPlayersStats is a list of players with a list of player stats.
     */
    private void createPlayerObjects(List<List<String>> argNhlPlayersStats) {
        logger.info("Creating player objects using parsed csv file.");
        for (List<String> player : argNhlPlayersStats) {
            playerObjects.add(createPlayerStatObject(player));
        }
    }

    public LeagueStats getLeagueStats() {
        return leagueStats;
    }
}
