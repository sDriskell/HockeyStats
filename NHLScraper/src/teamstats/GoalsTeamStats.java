package teamstats;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helpers.StatConverterHelper;

/**
 * Any goal scored outside of a shootout.
 */
public class GoalsTeamStats {
    private static final Logger LOG = LogManager.getLogger(GoalsTeamStats.class);
    
    private static final int EXPECTED_LENGTH_OF_ARG = 6;
    
    private Integer goalsFor;
    private Integer goalsAgainst;
    
    private BigDecimal goalsForPercentage;
    
    private BigDecimal expectedGoalsFor;
    private BigDecimal expectedGoalsAgainst;
    private BigDecimal expectedGoalsForPercentage;
    
    public GoalsTeamStats(String[] argGoalsTeamStats) {
        if (argGoalsTeamStats.length < EXPECTED_LENGTH_OF_ARG) {
            LOG.error("Incorrect array/stat size for goal stats.");
        }
        
        goalsFor = StatConverterHelper.generateIntegerStat(argGoalsTeamStats[0]);
        goalsAgainst = StatConverterHelper.generateIntegerStat(argGoalsTeamStats[1]);
        
        goalsForPercentage = StatConverterHelper.generateBigDecimalStat(argGoalsTeamStats[2]);
        
        expectedGoalsFor = StatConverterHelper.generateBigDecimalStat(argGoalsTeamStats[3]);
        expectedGoalsAgainst = StatConverterHelper.generateBigDecimalStat(argGoalsTeamStats[4]);
        expectedGoalsForPercentage = StatConverterHelper.generateBigDecimalStat(argGoalsTeamStats[5]);
    }

    public Integer getGoalsFor() {
        return goalsFor;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }

    public BigDecimal getGoalsForPercentage() {
        return goalsForPercentage;
    }

    public BigDecimal getExpectedGoalsFor() {
        return expectedGoalsFor;
    }

    public BigDecimal getExpectedGoalsAgainst() {
        return expectedGoalsAgainst;
    }

    public BigDecimal getExpectedGoalsForPercentage() {
        return expectedGoalsForPercentage;
    }
}
