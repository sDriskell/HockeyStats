package input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class used to consume input data from https://www.naturalstattrick.com/
 */
public class HockeyTeamStatConsumer {
    private static final Logger LOG = LogManager.getLogger(HockeyTeamStatConsumer.class);

    private static final String ELEMENT_SEPERATOR = ",";

    private HockeyTeamStatConsumer() {
        // Private constructor to protect from having it instantiated.
    }

    /**
     * Populate a List with String arrays that contain the team stats read from file
     * provided.
     * 
     * @return List of String arrays with team stat lines for each list element
     * @throws IOException if file is missing or named differently than expected
     */
    public static List<String[]> generateTeamStats(String argFileName) throws IOException {
        List<String[]> rawTeamStats = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(argFileName))) {
            rawTeamStats.addAll(buildRawTeamStats(input));
        }
        catch (IOException e) {
            LOG.fatal("File not found or exceptable.");
            e.printStackTrace();
        }

        return rawTeamStats;
    }

    /**
     * Reads input object line by line and populates the list with results.
     * 
     * @param input consists of BufferedReader object that will be reading the input
     *              file with team stats
     * @throws IOException if file is missing or named differently than expected
     */
    private static List<String[]> buildRawTeamStats(BufferedReader input) throws IOException {
        List<String[]> tempTeamStats = new ArrayList<>();

        for (String line = input.readLine(); line != null; line = input.readLine()) {
            String[] tempArray = line.split(ELEMENT_SEPERATOR);
            tempTeamStats.add(tempArray);
        }

        // Removes header so that we're only given the teams and their stats.
        tempTeamStats.remove(0);

        return tempTeamStats;
    }
}
