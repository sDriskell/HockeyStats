package main;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import process.Processor;

/**
 * Simple NHL tool to visualize statistical data from Hockey-Reference.com.
 * 
 * @author sldri
 */
public class NhlApp {
    private static final Logger logger = LogManager.getLogger(NhlApp.class);

    public static void main(String... args) throws IOException {
        logger.info("Starting stats processor object.");
        Processor statProcessor = new Processor();
    }
}
