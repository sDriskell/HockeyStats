package process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.NhlApp;
import stats.BasePlayerStats;
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

    private List<List<String>> rawSkatersBasicStats;
    private List<List<String>> rawTeamStandings;

    private List<BasePlayerStats> playerObjects = new ArrayList<>();
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
        logger.info("Processing NHL skater basic stats file.");
        ProcessCsvFile processCsvFile = new ProcessCsvFile();
        
        rawSkatersBasicStats = new ArrayList<>();
        rawSkatersBasicStats = processCsvFile.processCsvFile(rawSkatersBasicStats, "nhlSkatersBasic.csv");

        logger.info("Populating players and stats.");
        rawSkatersBasicStats.remove(0);  // Excess header row removed
        createPlayerObjects(rawSkatersBasicStats);
        
        logger.info("Processing NHL team standings.");
        rawTeamStandings = processCsvFile.processCsvFile(rawSkatersBasicStats, "nhlTeamStandings.csv");
        rawTeamStandings.remove(0); // Pop off header
        
        logger.info("Assigning players to teams.");
        leagueStats = new LeagueStats(playerObjects);
    }
 
    /**
     * Factory method making player and stats object(s).
     * 
     * @param argNhlPlayerStats is a list of player information
     * @return NhlPlayerStats object with the arguments values added
     */
    private BasePlayerStats createPlayerStatObject(List<String> argNhlPlayerStats) {
        return new BasePlayerStats(argNhlPlayerStats);
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
