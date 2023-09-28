package stats.teams;

import java.math.BigDecimal;

import helpers.StatConverterHelper;
import stats.IStats;

/**
 * Template for advanced stats used for teams.
 */
public class AdvancedStat implements IStats {
    private int statFor;
    private int statAgainst;

    private BigDecimal statForPercentage;

    /**
     * Class constructor that builds the advanced stat object.
     * 
     * @param argStatFor           String value of stat for the team
     * @param argStatAgainst       String value of stat against the team
     * @param argStatForPercentage String value for percentage of stat for team
     */
    public AdvancedStat(String argStatFor, String argStatAgainst, String argStatForPercentage) {
        statFor = StatConverterHelper.generateIntegerStat(argStatFor);
        statAgainst = StatConverterHelper.generateIntegerStat(argStatAgainst);

        statForPercentage = StatConverterHelper.generateBigDecimalStat(argStatForPercentage);
    }

    public int getStatFor() {
        return statFor;
    }

    public int getStatAgainst() {
        return statAgainst;
    }

    public BigDecimal getStatForPercentage() {
        return statForPercentage;
    }
}
