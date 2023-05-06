package process;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class ProcessCsvFile {
    private static final Logger logger = LogManager.getLogger(ProcessCsvFile.class);

    public ProcessCsvFile() {
        logger.info("CSV scraper object initialized.");
    }

    /**
     * Creates a List of a List of strings with each element being a unique entity
     * consisting of a list of statistical data for that entity.
     * 
     * @param csvFileName is the file name to be processed
     * @return List<List<String>> where each element consists of multiple elements
     *         each being some form of statistical data
     * @throws IOException
     */
    public static List<List<String>> processCsvFile(String csvFileName) throws IOException {
        logger.info("Ingesting csv file -> " + csvFileName);
        List<List<String>> tempStatsHolder = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFileName))) {
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

    /**
     * Creates a Map consisting of teams abbreviated names and full names.
     * 
     * @param csvFileName name of team file being ingested
     * @return Map<String, String> of abbv. names and full names of teams
     * @throws IOException throws if file is missing or incorrect name
     */
    public Map<String, String> generateTeamMap(String csvFileName) throws IOException {
        logger.info("Intake of team csv file.");

        try (Stream<String> lines = Files.lines(Paths.get(csvFileName))) {
            return lines.map(line -> line.split(",")).collect(Collectors.toMap(line -> line[0], line -> line[1]));
        }
    }
}
