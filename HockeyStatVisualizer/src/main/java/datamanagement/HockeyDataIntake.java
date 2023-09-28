package datamanagement;

import java.io.IOException;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import input.HockeyStatConsumer;
import stats.EStatTypes;
import stats.IStats;

/**
 * Class handles the flow and process of creating the stat objects to be
 * compiled in the form of a "Map of Maps".
 */
public class HockeyDataIntake {
    private static final Logger LOG = LogManager.getLogger(HockeyDataIntake.class);
    
    private static final String TEAM_FILE_NAME = "./games.csv";
    
    private static Map<String, Map<EStatTypes, IStats>> teamStats;
    
    public HockeyDataIntake() {
        createStatObjects();
    } 
    
    /**
     * Initiate the process to generate stat objects using the HockeyStatConsumer.
     */
    private void createStatObjects() {
        try {
            LOG.info("Building team stats objects.");
            teamStats = HockeyStatConsumer.parseStats(TEAM_FILE_NAME);
        }
        catch (IOException e) {
            LOG.fatal("Stat file {} could not be created", TEAM_FILE_NAME);
            e.printStackTrace();
        }
    }
}
