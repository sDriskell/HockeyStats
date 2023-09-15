package nhlapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Processors.HockeyProcessor;

public class NhlApp {
    private static final Logger LOG = LogManager.getLogger(NhlApp.class);
    
    private static HockeyProcessor processor;
    
    public static void main(String... args) {
        LOG.info("Starting NHL Hockey Processor.");
        processor = new HockeyProcessor();
    }
}
