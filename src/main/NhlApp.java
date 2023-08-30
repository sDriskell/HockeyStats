package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import processors.HockeyProcessor;

/**
 * Simple NHL tool to visualize statistical data from: 
 *  https://www.naturalstattrick.com/
 * 
 * @author Shane
 */
public class NhlApp {
    private static final Logger LOG = LogManager.getLogger(NhlApp.class);
    
    private static HockeyProcessor processor;
    
    public static void main(String... args) {       
        LOG.info("Starting processor.");
        processor = new HockeyProcessor();
    }
}
