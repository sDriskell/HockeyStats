package process;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import main.NhlApp;

public class ProcessCsvFile {
    private static final Logger logger = LogManager.getLogger(ProcessCsvFile.class);

    
    public ProcessCsvFile() {
        logger.info("CSV scraper object initialized.");
    }

    /**
     * Creates a List of a List of strings with players and any statistics that come
     * with that player.
     * 
     * @param argList is list to store scraped players.
     * @param argCsvFileName is the file name to be processed
     * @return Players and their stats in the form of Strings
     * @throws IOException
     * @throws FileNotFoundException
     */
    public List<List<String>>
            processCsvFile(List<List<String>> argList, String argCsvFileName)
            throws IOException {
        logger.info("Ingesting csv file -> " + argCsvFileName);
        List<List<String>> tempStatsHolder = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(argCsvFileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",", -1);
                tempStatsHolder.add(Arrays.asList(values));
            }
        }
        catch (IOException e) {
            logger.error("File not found or incorrect format.");
        }
        return tempStatsHolder;
    }
}
