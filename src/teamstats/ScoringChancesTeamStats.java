package teamstats;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helpers.StatConverterHelper;

/**
 * As defined by blog.war-on-ice.com:
 * In the low danger zone, unblocked rebounds and rush shots only.
 * In the medium danger zone, all unblocked shots.
 * In the high danger zone, all shot attempts.
 */
public class ScoringChancesTeamStats {
    public static final Logger LOG = LogManager.getLogger(ScoringChancesTeamStats.class);
    
    private static final int EXPECTED_LENGTH_OF_ARG = 3;

    private Integer scoringChancesFor;
    private Integer scoringChancesAgainst;
    
    private BigDecimal scoringChancesForPercentage;
    
    public ScoringChancesTeamStats(String[] argScoringChanceStats) {
        if (argScoringChanceStats.length < EXPECTED_LENGTH_OF_ARG) {
            LOG.error("Incorrect array/stat size for scoring chances stats.");
            throw new IndexOutOfBoundsException();
        }
        
        scoringChancesFor = StatConverterHelper.generateIntegerStat(argScoringChanceStats[0]);
        scoringChancesAgainst = StatConverterHelper.generateIntegerStat(argScoringChanceStats[1]);
        scoringChancesForPercentage = StatConverterHelper.generateBigDecimalStat(argScoringChanceStats[2]);
    }

    public Integer getScoringChancesFor() {
        return scoringChancesFor;
    }

    public Integer getScoringChancesAgainst() {
        return scoringChancesAgainst;
    }

    public BigDecimal getScoringChancesForPercentage() {
        return scoringChancesForPercentage;
    }
}
