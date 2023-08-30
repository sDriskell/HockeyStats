package teamstats.datamanagement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import input.HockeyStatConsumer;

/**
 * 
 */
public class HockeyDataIntake {
    private static final Logger LOG = LogManager.getLogger(HockeyDataIntake.class);

    private static final String TEAM_FILE_NAME = "./games.csv";
    private static final String PLAYER_FILE_NAME = "./players.csv";
    private static final String GOALIE_FILE_NAME = "./goalies.csv";

    private List<String[]> rawTeamList;
    private List<String[]> rawPlayerList;
    private List<String[]> rawGoalieList;

    public HockeyDataIntake() {
        execute();
    }

    public void execute() {
        LOG.info("Intaking csv files.");
        rawTeamList = processCsvStatFile(TEAM_FILE_NAME);
    }

    /**
     * Uses a String argument with path to csv file to process. This will execute
     * the process to generate stats and return a List with String arrays.
     * 
     * @param argFileName String name of file and path csv file is located at
     * @return a List of String arrays with stats parsed for the file given
     */
    private List<String[]> processCsvStatFile(String argFileName) {
        List<String[]> rawStatList = new ArrayList<>();

        LOG.info("Starting stat sheet consumption for: " + argFileName);

        try {
            rawStatList = HockeyStatConsumer.generateStats(argFileName);
        }
        catch (IOException e) {
            LOG.error("File name missing.");
        }

        return rawStatList;
    }

    public List<String[]> getRawTeamList() {
        return rawTeamList;
    }

    public List<String[]> getRawPlayerList() {
        return rawPlayerList;
    }

    public List<String[]> getRawGoalieList() {
        return rawGoalieList;
    }
}
