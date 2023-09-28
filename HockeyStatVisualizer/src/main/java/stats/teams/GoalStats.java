package stats.teams;

import java.math.BigDecimal;

import helpers.StatConverterHelper;
import stats.IStats;

/**
 * Team stat class for goals.
 */
public class GoalStats implements IStats {
    private int goalsFor;
    private int goalsAgainst;

    private BigDecimal goalsForPercentage;
    private BigDecimal expectedGoalsFor;
    private BigDecimal expectedGoalsAgainst;
    private BigDecimal expectedGoalsForPercentage;

    /**
     * Constructor handled by the builder class.
     * 
     * @param builder Builder object to populate class attributes
     */
    private GoalStats(Builder builder) {
        goalsFor = builder.goalsFor;
        goalsAgainst = builder.goalsAgainst;
        
        goalsForPercentage = builder.goalsForPercentage;
        expectedGoalsFor = builder.expectedGoalsFor;
        expectedGoalsAgainst = builder.expectedGoalsAgainst;
        expectedGoalsForPercentage = builder.expectedGoalsForPercentage;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
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

    /**
     * Nested class to be used in a Builder Design Pattern.
     */
    public static class Builder {
        private int goalsFor;
        private int goalsAgainst;

        private BigDecimal goalsForPercentage;
        private BigDecimal expectedGoalsFor;
        private BigDecimal expectedGoalsAgainst;
        private BigDecimal expectedGoalsForPercentage;

        /**
         * Base constructor method for Builder.
         * 
         * @param argGoalsFor        String object of goals for the team
         * @param argGoalsAgainst    String object of goals against the team
         * @param goalsForPercentage String object for percentage of goals for the team
         */
        public Builder(String argGoalsFor, String argGoalsAgainst, String argGoalsForPercentage) {
            goalsFor = StatConverterHelper.generateIntegerStat(argGoalsFor);
            goalsAgainst = StatConverterHelper.generateIntegerStat(argGoalsAgainst);
            goalsForPercentage = StatConverterHelper.generateBigDecimalStat(argGoalsForPercentage);
        }

        public Builder expectedGoalsFor(String argExpectedGoalsFor) {
            expectedGoalsFor = StatConverterHelper.generateBigDecimalStat(argExpectedGoalsFor);
            return this;
        }

        public Builder expectedGoalsAgainst(String argExpectedGoalsAgainst) {
            expectedGoalsAgainst =
                    StatConverterHelper.generateBigDecimalStat(argExpectedGoalsAgainst);
            return this;
        }

        public Builder expectedGoalsForPercentage(String argExpectedGoalsForPercentage) {
            expectedGoalsForPercentage =
                    StatConverterHelper.generateBigDecimalStat(argExpectedGoalsForPercentage);
            return this;
        }
        
        public GoalStats build() {
            return new GoalStats(this);
        }
    }
}
