package teamstats;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helpers.StatConverterHelper;

/**
 * Any unblocked shot attempt (goals, shots on net and misses) outside of the shootout.
 */
public class FenwickTeamStats {
    private static final Logger LOG = LogManager.getLogger(FenwickTeamStats.class);
    
    private static final int EXPECTED_LENGTH_OF_ARG = 3;
    
    private Integer fenwickFor;
    private Integer fenwickAgainst;
    
    private BigDecimal fenwickForPercentage;
    
    public FenwickTeamStats(String[] argFenwickStats) {
        if (argFenwickStats.length < EXPECTED_LENGTH_OF_ARG) {
            LOG.error("Incorrect array/stat size for Fenwick stats.");
            throw new ArrayIndexOutOfBoundsException();
        }
        
        fenwickFor = StatConverterHelper.generateIntegerStat(argFenwickStats[0]);
        fenwickAgainst = StatConverterHelper.generateIntegerStat(argFenwickStats[1]);
        fenwickForPercentage = StatConverterHelper.generateBigDecimalStat(argFenwickStats[2]);
    }

    public Integer getFenwickFor() {
        return fenwickFor;
    }

    public Integer getFenwickAgainst() {
        return fenwickAgainst;
    }

    public BigDecimal getFenwickForPercentage() {
        return fenwickForPercentage;
    }
}
