package stats;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.NhlApp;
import stats.refined.RefinedTeamStats;
import stats.BasePlayerStats;

public class SkaterStats {
    private static final Logger logger = LogManager.getLogger(SkaterStats.class);

    private Map<String, List<BasePlayerStats>> baseTeams;
    private List<BasePlayerStats> playerObjects;

    private List<BaseTeamStats> baseTeamStats;
    private List<RefinedTeamStats> refinedTeamStats;

    /**
     * Constructor for league level player stats; to include map of teams and player
     * objects
     * 
     * @param argNhlPlayerObjects a list of player objects with stats to be compiled
     */
    public SkaterStats(List<BasePlayerStats> argNhlPlayerObjects) {
        playerObjects = argNhlPlayerObjects;
        compileTeams();
        createNhlTeamStats();
        refineNhlTeamStats();
    }

    /**
     * Assigns players to teams in a map with key: team, value: list of players
     */
    private void compileTeams() {
        baseTeams = new HashMap<>();
        List<BasePlayerStats> tempList;

        for (BasePlayerStats player : playerObjects) {
            if (baseTeams.containsKey(player.getTeam())) {
                tempList = baseTeams.get(player.getTeam());
                tempList.add(player);
                baseTeams.put(player.getTeam(), tempList);
            }
            else {
                tempList = new ArrayList<>();
                tempList.add(player);
                baseTeams.put(player.getTeam(), tempList);
            }
        }
    }

    /**
     * Generates a list of team stat objects used to handle team stats and players
     */
    private void createNhlTeamStats() {
        baseTeamStats = new ArrayList<>();

        baseTeams.entrySet().stream().forEach(team -> {
            logger.info(new StringBuilder("Team " + team.getKey() + " stats generated"));
            BaseTeamStats nhlTeamObjs = new BaseTeamStats(team.getKey(), team.getValue());
            baseTeamStats.add(nhlTeamObjs);
        });
    }

    /**
     * Initiates the process of generating more detailed team stats from base stats
     * derived from Hockey Reference.
     */
    private void refineNhlTeamStats() {
        refinedTeamStats = new ArrayList<>();

        for (BaseTeamStats baseTeam : baseTeamStats) {
            refinedTeamStats.add(new RefinedTeamStats(baseTeam));
        }

        for (RefinedTeamStats refinedTeam : refinedTeamStats) {
            logger.info("Team:\t{}\tAverage:\t{}", refinedTeam,
                    refinedTeam.getGoals().getAveragePlayerGoals());
            logger.info("\t\t\tMedian: \t{}", refinedTeam.getGoals().getMedianPlayerGoals());
        }
    }

    /**
     * Short print method to merely list all teams and players on team
     */
    public void printAllPlayerRoster() {
        baseTeams.entrySet().stream().forEach(team -> {
            for (BasePlayerStats player : team.getValue()) {
                logger.info("Team:\t{} \tPlayer:\t{}", player.getTeam(), player);
            }
        });
    }

    /**
     * This method will be used when looking to retrieve all PlayerStats objects
     * related to the same player. It will inspect all teams and free agency and
     * compile them into a single List to be returned for use.
     * 
     * @param name String of player's name to be searched for across all teams/free
     *             agency
     * @return List of PlayerStat objects featuring the name passed in the argument.
     *         This will include across all teams and free agency
     */
    public List<BasePlayerStats> fetchAllStatsOnPlayer(String name) {
        List<BasePlayerStats> playerStatsAcrossLeague = new ArrayList<>();

        for (RefinedTeamStats team : refinedTeamStats) {
            parseTeamForPlayer(name, playerStatsAcrossLeague, team);
        }

        return playerStatsAcrossLeague;
    }

    /**
     * Searches team parameter for name parameter and adds to List parameter all
     * equal PlayerStats objects with similar name.
     * 
     * @param name                    String of player name to search for
     * @param playerStatsAcrossLeague List of PlayerStats objects that have similar
     *                                name
     * @param team                    RefinedTeamStats object to be inspected for
     *                                player
     */
    private void parseTeamForPlayer(String name, List<BasePlayerStats> playerStatsAcrossLeague,
            RefinedTeamStats team) {
        for (BasePlayerStats player : team.getRawTeamStats().getTeamMembers()) {
            if (player.toString().equalsIgnoreCase(name)) {
                playerStatsAcrossLeague.add(player);
            }
        }
    }
}
