package factory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import process.ProcessCsvFile;
import stats.AdvancedSkaterStats;
import stats.BasicSkaterStats;
import stats.GoalieStats;
import stats.IPlayerStats;

/**
 * The factory object will handle the logic and manipulation of the statistical
 * data derived from the scraper class.
 * 
 * @author sldri
 *
 */
public class SkaterFactory {
    private static final Logger logger = LogManager.getLogger(SkaterFactory.class);

    private SkaterFactory() {
        // Hidden so as to be only used statically.
    }

    /**
     * Simple utility method that handles returning a list with the results of the
     * csv file provided in the method's argument.
     * 
     * @param fileName String with csv file name to be processed
     * @return List of lists with player stats
     * @throws IOException if file name is not found
     */
    private static List<List<String>> createListFromCsvFile(String fileName) throws IOException {
        logger.info("Processing file: {}", fileName);

        // TODO: Clean up scraper to omit ugly, first line entry in csv files
        List<List<String>> tempStatList = ProcessCsvFile.processCsvFile(fileName);
        tempStatList.remove(0); // Remove excess header line

        return tempStatList;
    }

    /**
     * 
     * 
     * @param <T>
     * @param playerStatType
     * @param skaterStatSource
     * @return
     * @throws IOException
     */
    public static <T> List<T> createSkaterObjects(String playerStatType, String skaterStatSource) throws IOException {
        logger.info("Parsing {} csv data.", playerStatType);
        List<List<String>> rawSkaterStats = createListFromCsvFile(skaterStatSource);

        logger.info("Creating skater objects.");
        List<IPlayerStats> skaterObjects = new ArrayList<>();

        // TODO: Refactor as this noticeably impacts performance when creating skater
        // objects
        for (List<String> player : rawSkaterStats) {
            if (player == null) {
                continue;
            }

            if (EStatisticTypes.BASIC_SKATER.getType().equals(playerStatType)) {
                skaterObjects.add(new BasicSkaterStats(player));
            }
            else if (EStatisticTypes.ADVANCED_SKATER.getType().equals(playerStatType)) {
                skaterObjects.add(new AdvancedSkaterStats(player));
            }
            else if (EStatisticTypes.GOALIE.getType().equals(playerStatType)) {
                skaterObjects.add(new GoalieStats(player));
            }
            else {
                logger.error("Skater type {} not recognized.", playerStatType);
            }
        }
        return (List<T>) skaterObjects;
    }

}
