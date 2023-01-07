package main;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import process.StatProcessor;
import ui.ControllerFrame;

/**
 * Simple NHL scraper that generates output of players with stats dependent on
 * input from user.
 * 
 * @author sldri
 * @link https://www.hockey-reference.com/leagues/NHL_[YYYY]_skaters.html
 * [YYYY] -> enter year to pull stats (ex. ...2022_skaters.html)
 */
public class NhlScraper {
    private static final Logger logger = LogManager.getLogger(NhlScraper.class);

    public static void main(String... args) throws IOException {
        logger.info("Starting stats processor object.");
        ControllerFrame controllerFrame = new ControllerFrame(new StatProcessor());
    }
}
