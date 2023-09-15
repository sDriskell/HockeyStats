package Processors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import datamanagement.HockeyDataIntake;

/**
 * Central component for handling the usage of statistical data used in the
 * project.
 */
public class HockeyProcessor {
    private static final Logger LOG = LogManager.getLogger(HockeyProcessor.class);

    private static HockeyDataIntake dataIntake;

    /**
     * Constructor for Hockey Processor for stat purposes.
     */
    public HockeyProcessor() {
        LOG.info("Starting intake process.");
        initiate();
    }

    private void initiate() {
        dataIntake = new HockeyDataIntake();
    }
}
