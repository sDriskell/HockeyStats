package teamstats;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helpers.StatConverterHelper;

/**
 * Class generating and storing Corsi stats. Corsi stats are any shots made
 * outside of a shootout.
 */
public class CorsiTeamStats {
    private static final Logger LOG = LogManager.getLogger(CorsiTeamStats.class);
    
    private static final int EXPECTED_LENGTH_OF_ARG = 3;
    
    private Integer corsiFor;
    private Integer corsiAgainst;
    
    private BigDecimal corsiForPercentage;


    public CorsiTeamStats(String[] argCorsiStats) {
        if (argCorsiStats.length < EXPECTED_LENGTH_OF_ARG) {
            LOG.error("Incorrect array/stat size for Corsi stats.");
            throw new ArrayIndexOutOfBoundsException();
        }

        corsiFor = StatConverterHelper.generateIntegerStat(argCorsiStats[0]);
        corsiAgainst = StatConverterHelper.generateIntegerStat(argCorsiStats[1]);
        corsiForPercentage = StatConverterHelper.generateBigDecimalStat(argCorsiStats[2]);
    }

    public Integer getCorsiFor() {
        return corsiFor;
    }


    public Integer getCorsiAgainst() {
        return corsiAgainst;
    }


    public BigDecimal getCorsiForPercentage() {
        return corsiForPercentage;
    }
}
