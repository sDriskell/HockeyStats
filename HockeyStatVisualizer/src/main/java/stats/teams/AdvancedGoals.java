package stats.teams;

import java.math.BigDecimal;

import helpers.StatConverterHelper;
import stats.IStats;

/**
 * Template to be used for different types of advanced analytics related to goal scoring.
 */
public class AdvancedGoals implements IStats {
    private int scoringChanceGoalsFor;
    private int scoringChanceGoalsAgainst;

    private BigDecimal scoringChanceGoalsForPercentage;
    private BigDecimal scoringChanceGoalsThatScored;
    private BigDecimal scoringChanceGoalsNotScored;

    /**
     * Constructor handled by the builder class.
     * 
     * @param builder Builder object to populate class attributes
     */
    private AdvancedGoals(Builder builder) {
        scoringChanceGoalsFor = builder.scoringChanceGoalsFor;
        scoringChanceGoalsAgainst = builder.scoringChanceGoalsAgainst;

        scoringChanceGoalsForPercentage = builder.scoringChanceGoalsForPercentage;
        scoringChanceGoalsThatScored = builder.scoringChanceGoalsThatScored;
        scoringChanceGoalsNotScored = builder.scoringChanceGoalsNotScored;
    }

    public int getScoringChanceGoalsFor() {
        return scoringChanceGoalsFor;
    }

    public int getScoringChanceGoalsAgainst() {
        return scoringChanceGoalsAgainst;
    }

    public BigDecimal getScoringChanceGoalsForPercentage() {
        return scoringChanceGoalsForPercentage;
    }

    public BigDecimal getScoringChanceGoalsThatScored() {
        return scoringChanceGoalsThatScored;
    }

    public BigDecimal getScoringChanceGoalsNotScored() {
        return scoringChanceGoalsNotScored;
    }

    /**
     * Nested class to be used in a Builder Design Pattern.
     */
    public static class Builder {
        private int scoringChanceGoalsFor;
        private int scoringChanceGoalsAgainst;

        private BigDecimal scoringChanceGoalsForPercentage;
        private BigDecimal scoringChanceGoalsThatScored;
        private BigDecimal scoringChanceGoalsNotScored;

        /**
         * Base constructor method for Builder.
         * 
         * @param argScoringChanceGoalsFor           String object for chances to score
         *                                           for team
         * @param argScoringChanceGoalsAgainst       String object for chances to score
         *                                           against team
         * @param argScoringChanceGoalsForPercentage String object for percentage of
         *                                           chance to score for team
         */
        public Builder(String argScoringChanceGoalsFor, String argScoringChanceGoalsAgainst,
                String argScoringChanceGoalsForPercentage) {
            scoringChanceGoalsFor =
                    StatConverterHelper.generateIntegerStat(argScoringChanceGoalsFor);
            scoringChanceGoalsAgainst =
                    StatConverterHelper.generateIntegerStat(argScoringChanceGoalsAgainst);
            scoringChanceGoalsForPercentage =
                    StatConverterHelper.generateBigDecimalStat(argScoringChanceGoalsForPercentage);
        }

        public Builder scoringChanceGoalsThatScored(String argScoringChanceGoalsThatScored) {
            scoringChanceGoalsThatScored =
                    StatConverterHelper.generateBigDecimalStat(argScoringChanceGoalsThatScored);
            return this;
        }

        public Builder scoringChanceGoalsNotScored(String argScoringChanceGoalsNotScored) {
            scoringChanceGoalsNotScored =
                    StatConverterHelper.generateBigDecimalStat(argScoringChanceGoalsNotScored);
            return this;
        }

        public AdvancedGoals build() {
            return new AdvancedGoals(this);
        }
    }
}
