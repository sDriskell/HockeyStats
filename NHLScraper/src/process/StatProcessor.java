package process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import factory.SkaterFactory;
import main.NhlApp;
import stats.AdvancedSkaterStats;
import stats.BasicSkaterStats;
import stats.GoalieStats;
import stats.IPlayerStats;

public class StatProcessor {
    private static final Logger logger = LogManager.getLogger(StatProcessor.class);

    private List<BasicSkaterStats> skaterBasic;
    private List<AdvancedSkaterStats> skaterAdvanced;
    private List<GoalieStats> goalie;

    private Map<String, List<BasicSkaterStats>> teamsBasic;
    private Map<String, List<AdvancedSkaterStats>> teamsAdvanced;
    private Map<String, List<GoalieStats>> teamsGoalie;

    public StatProcessor() throws IOException {
        createPlayerLists();
        setPlayersToTeams();
    }

    /**
     * Initializes the stats related lists for all league players.
     * 
     * @throws IOException
     */
    private void createPlayerLists() throws IOException {
        logger.info("creating Skater objects.");

        skaterBasic = SkaterFactory.createSkaterObjects("basic", "nhlSkatersBasic.csv");
        skaterAdvanced = SkaterFactory.createSkaterObjects("advanced", "nhlSkatersAdvanced.csv");
        goalie = SkaterFactory.createSkaterObjects("goalie", "nhlGoalies.csv");
    }

    /**
     * Creates maps for basic, advanced, and goalie stats by using the team as the
     * key and the list of players as the value.
     */
    private void setPlayersToTeams() {
        logger.info("Setting player objects to teams");

        // TODO: Refactor DRY breakage
        
        teamsBasic = new HashMap<>();
        List<BasicSkaterStats> basicTempList;

        for (BasicSkaterStats player : skaterBasic) {
            if (teamsBasic.containsKey(player.team)) {
                basicTempList = teamsBasic.get(player.team);
                basicTempList.add(player);
                teamsBasic.put(player.team, basicTempList);
            }
            else {
                basicTempList = new ArrayList<>();
                basicTempList.add(player);
                teamsBasic.put(player.team, basicTempList);
            }
        }

        teamsAdvanced = new HashMap<>();
        List<AdvancedSkaterStats> advancedTempList;
        
        for (AdvancedSkaterStats player : skaterAdvanced) {
            if (teamsAdvanced.containsKey(player.team)) {
                advancedTempList = teamsAdvanced.get(player.team);
                advancedTempList.add(player);
                teamsAdvanced.put(player.team, advancedTempList);
            }
            else {
                advancedTempList = new ArrayList<>();
                advancedTempList.add(player);
                teamsAdvanced.put(player.team, advancedTempList);
            }
        }
        
        teamsGoalie = new HashMap<>();
        List<GoalieStats> goalieTempList;
        
        for (GoalieStats player : goalie) {
            if (teamsGoalie.containsKey(player.team)) {
                goalieTempList = teamsGoalie.get(player.team);
                goalieTempList.add(player);
                teamsGoalie.put(player.team, goalieTempList);
            }
            else {
                goalieTempList = new ArrayList<>();
                goalieTempList.add(player);
                teamsGoalie.put(player.team, goalieTempList);
            }
        }
    }
}
