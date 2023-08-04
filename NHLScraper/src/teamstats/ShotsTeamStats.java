package teamstats;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helpers.StatConverterHelper;

/**
 * Any shot attempt on net (goals and shots on net) outside of the shootout.
 */
public class ShotsTeamStats {
    private static final Logger LOG = LogManager.getLogger(ShotsTeamStats.class);

    private static final int EXPECTED_LENGTH_OF_ARG = 3;
    
    private Integer shotsFor;
    private Integer shotsAgainst;
    
    private BigDecimal shotForPercentage;
    
    public ShotsTeamStats(String[] argShotStats) {
        if (argShotStats.length < EXPECTED_LENGTH_OF_ARG) {
            LOG.error("Incorrect array/stat size for shot stats.");
            throw new ArrayIndexOutOfBoundsException();
        }
        
        shotsFor = StatConverterHelper.generateIntegerStat(argShotStats[0]);
        shotsAgainst = StatConverterHelper.generateIntegerStat(argShotStats[1]);
        shotForPercentage = StatConverterHelper.generateBigDecimalStat(argShotStats[1]);
    }

    public Integer getShotsFor() {
        return shotsFor;
    }

    public Integer getShotsAgainst() {
        return shotsAgainst;
    }

    public BigDecimal getShotForPercentage() {
        return shotForPercentage;
    }
}
