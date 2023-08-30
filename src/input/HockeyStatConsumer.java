package input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class used to consume input data from https://www.naturalstattrick.com/
 */
public class HockeyStatConsumer {
    private static final Logger LOG = LogManager.getLogger(HockeyStatConsumer.class);

    private static final String ELEMENT_SEPERATOR = ",";

    private HockeyStatConsumer() {
        // Private constructor to protect from having it instantiated.
    }

    /**
     * Populate a List with String arrays that contain the stats read from file
     * provided.
     * 
     * @return List of String arrays with team stat lines for each list element
     * @throws IOException if file is missing or named differently than expected
     */
    public static List<String[]> generateStats(String argFileName) throws IOException {
        List<String[]> rawStats = new ArrayList<>();

        try (BufferedReader input = new BufferedReader(new FileReader(argFileName))) {
            CSVFormat csvRaw = CSVFormat.DEFAULT.builder().build();
            
            Iterable<CSVRecord> records = csvRaw.parse(input);
                        
            for (CSVRecord entry : records) {
                rawStats.add(entry.values());
            }
            
        }
        catch (IOException e) {
            LOG.fatal("File not found or exceptable.");
        }
        
        // pop header row off
        rawStats.remove(0);
        
        return rawStats;
    }
}
