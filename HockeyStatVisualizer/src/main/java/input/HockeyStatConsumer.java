package input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import stats.EStatTypes;
import stats.IStats;
import stats.teams.StandardTeamStats;
/**
 * Class for creating the stat objects and compiling them into a Map of Maps.
 */
public class HockeyStatConsumer {
    private static final Logger LOG = LogManager.getLogger(HockeyStatConsumer.class);

    /**
     * Private constructor to maintain static behavior.
     */
    private HockeyStatConsumer() {
        // Private constructor to protect from having it instantiated.
    }

    /**
     * Leverage Apache Commons library for parsing a CSV file and returning the
     * results in a Map with stat objects.
     * 
     * @param  argFileName file name to ascertain flow of construction process
     * @return             Map of maps with stat objects associated with unique
     *                     identifier
     * @throws IOException if file name is incorrect or non-existent
     */
    public static Map<String, Map<EStatTypes, IStats>> generateStats(String argFileName)
            throws IOException {
        Map<String, Map<EStatTypes, IStats>> teamStats = new HashMap<>();

        try (BufferedReader input = new BufferedReader(new FileReader(argFileName))) {
            CSVFormat csvRaw = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .setAllowMissingColumnNames(true)
                    .build();

            Map<EStatTypes, IStats> elementStats = new EnumMap<>(EStatTypes.class);

            Iterable<CSVRecord> records = csvRaw.parse(input);

            for (CSVRecord team : records) {
                LOG.info("Building stat object(s) for team: {}", team.get("Team"));
                
                elementStats.put(EStatTypes.STANDARD,
                        new StandardTeamStats.Builder(team.get("Team"))
                                .gamesPlayed(team.get("GP"))
                                .timeOnIce(team.get("TOI"))
                                .wins(team.get("W"))
                                .losses(team.get("L"))
                                .overtimeLosses(team.get("OTL"))
                                .nonShootoutWins(team.get("ROW"))
                                .points(team.get("Points"))
                                .pointPercentage(team.get("Point %"))
                                .build());

                teamStats.put(team.get("Team"), elementStats);
            }
        }
        catch (IOException e) {
            LOG.fatal("File not found, incorrect name, or not exceptable formatting.");
            e.printStackTrace();
        }
        return teamStats;
    }
}
