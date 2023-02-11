package stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import stats.refined.RefinedTeamStats;
import stats.BasicSkaterStats;

public class SkaterStats {
    private static final Logger logger = LogManager.getLogger(SkaterStats.class);

    private Map<String, List<BasicSkaterStats>> baseTeams;
    private List<BasicSkaterStats> playerObjects;

    private List<BasicTeamStats> baseTeamStats;
    private List<RefinedTeamStats> refinedTeamStats;

    /**
     * Constructor for league level player stats; to include map of teams and player
     * objects
     * 
     * @param argNhlPlayerObjects a list of player objects with stats to be compiled
     */
    public SkaterStats(List<BasicSkaterStats> argNhlPlayerObjects) {
        playerObjects = argNhlPlayerObjects;
        compileTeams();
        createBasicTeamStats();
        refineNhlTeamStats();
    }

    /**
     * Assigns players to teams in a map with key: team, value: list of players
     */
    private void compileTeams() {
        baseTeams = new HashMap<>();
        List<BasicSkaterStats> tempList;

        for (BasicSkaterStats player : playerObjects) {
            if (baseTeams.containsKey(player.team)) {
                tempList = baseTeams.get(player.team);
                tempList.add(player);
                baseTeams.put(player.team, tempList);
            }
            else {
                tempList = new ArrayList<>();
                tempList.add(player);
                baseTeams.put(player.team, tempList);
            }
        }
    }

    /**
     * Generates a list of team stat objects used to handle team stats and players
     */
    private void createBasicTeamStats() {
        baseTeamStats = new ArrayList<>();

        baseTeams.entrySet().stream().forEach(team -> {
            logger.info(new StringBuilder("Team " + team.getKey() + " stats generated"));
            BasicTeamStats nhlTeamObjs = new BasicTeamStats(team.getKey(), team.getValue());
            baseTeamStats.add(nhlTeamObjs);
        });
    }

    /**
     * Initiates the process of generating more detailed team stats from base stats
     * derived from Hockey Reference.
     */
    private void refineNhlTeamStats() {
        refinedTeamStats = new ArrayList<>();

        for (BasicTeamStats baseTeam : baseTeamStats) {
            refinedTeamStats.add(new RefinedTeamStats(baseTeam));
        }
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
    public List<BasicSkaterStats> fetchAllStatsOnPlayer(String name) {
        List<BasicSkaterStats> playerStatsAcrossLeague = new ArrayList<>();

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
     * @param playerStatsAcrossLeague List of BasicSkaterStats objects that have similar
     *                                name
     * @param team                    RefinedTeamStats object to be inspected for
     *                                player
     */
    private void parseTeamForPlayer(String name, List<BasicSkaterStats> playerStatsAcrossLeague,
            RefinedTeamStats team) {
        for (BasicSkaterStats player : team.getRawTeamStats().getTeamMembers()) {
            if (player.toString().equalsIgnoreCase(name)) {
                playerStatsAcrossLeague.add(player);
            }
        }
    }
}
