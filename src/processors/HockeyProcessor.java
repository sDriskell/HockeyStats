package processors;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import teamstats.datamanagement.HockeyDataIntake;

/**
 * 
 */
public class HockeyProcessor {
    private static final Logger LOG = LogManager.getLogger(HockeyProcessor.class);

    private static Map<String, Map<String, Object>> teamStatObjects = new HashMap<>();

    private static HockeyDataIntake dataIntake;

    public HockeyProcessor() {
        LOG.info("Starting intake process.");
        initiate();
    }

    private void initiate() {
        dataIntake = new HockeyDataIntake();
    }
}
