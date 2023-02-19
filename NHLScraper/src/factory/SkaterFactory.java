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
 * The factory object will handle the logic and manipulation of the
 * statistical data derived from the scraper class.
 * 
 * @author sldri
 *
 */
public class SkaterFactory {
    private static final Logger logger = LogManager.getLogger(SkaterFactory.class);

    private List<List<String>> rawSkaterStats;
    private List<IPlayerStats> skaterObjects;

    public SkaterFactory(String skaterStatSource, String playerStatType) throws IOException {
        logger.info("Parsing {} csv data.", playerStatType);
        createListFromCsvFile(skaterStatSource);

        logger.info("Creating skater objects.");
        createSkaterObjects(playerStatType);

        logger.info("Assigning players to teams.");
    }

    private void createListFromCsvFile(String fileName) throws IOException {
        logger.info("Processing file: {}", fileName);
        rawSkaterStats = new ArrayList<>();

        // TODO: Clean up scraper to omit ugly, first line entry in csv files
        rawSkaterStats = ProcessCsvFile.processCsvFile(fileName);
        rawSkaterStats.remove(0); // Remove excess header line
    }

    private void createSkaterObjects(String playerStatType) {
        for(List<String> player : rawSkaterStats) {
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
    }
}
