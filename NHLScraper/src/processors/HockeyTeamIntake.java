package processors;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import input.HockeyTeamStatConsumer;

public class HockeyTeamIntake {
    private static final Logger logger = LogManager.getLogger(HockeyTeamIntake.class);
    
    private static final String TEAM_FILE_NAME = "./games.csv";
    private static final String PLAYER_FILE_NAME = "./players.csv";
    private static final String GOALIE_FILE_NAME = "./goalies.csv";

    private HockeyTeamIntake() {
        // Set to private so that it is not instantiated in code.
    }

    public static void processTeamStatsCsv() {
        List<String[]> rawTeamStats;

        logger.info("Starting stat sheet consumption.");
        
        try {
            rawTeamStats = HockeyTeamStatConsumer.generateTeamStats(TEAM_FILE_NAME);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
