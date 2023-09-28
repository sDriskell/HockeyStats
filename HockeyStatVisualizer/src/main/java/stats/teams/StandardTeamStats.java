package stats.teams;

import java.math.BigDecimal;

import helpers.StatConverterHelper;
import stats.IStats;

/**
 * Standard related team stats class.
 */
public class StandardTeamStats implements IStats {
    private String teamName;
    private int gamesPlayed;
    private BigDecimal timeOnIce;

    private int wins;
    private int losses;
    private int overtimeLosses;
    private int nonShootoutWins;

    private int points;
    private BigDecimal pointPercentage;

    /**
     * Constructor for standard related team stats.
     * 
     * @param builder object for builder design pattern
     */
    private StandardTeamStats(Builder builder) {
        teamName = builder.teamName;
        gamesPlayed = builder.gamesPlayed;
        timeOnIce = builder.timeOnIce;
        wins = builder.wins;
        losses = builder.losses;

        overtimeLosses = builder.overtimeLosses;
        nonShootoutWins = builder.nonShootoutWins;
        points = builder.points;
        pointPercentage = builder.pointPercentage;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public BigDecimal getTimeOnIce() {
        return timeOnIce;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getOvertimeLosses() {
        return overtimeLosses;
    }

    public int getNonShootoutWins() {
        return nonShootoutWins;
    }

    public int getPoints() {
        return points;
    }

    public BigDecimal getPointPercentage() {
        return pointPercentage;
    }

    /**
     * Nested class to be used in a Builder Design Pattern.
     */
    public static class Builder {
        private String teamName;
        private int gamesPlayed;
        private BigDecimal timeOnIce;

        private int wins;
        private int losses;
        private int overtimeLosses;
        private int nonShootoutWins;

        private int points;
        private BigDecimal pointPercentage;

        /**
         * Builder constructor for standard team stats.
         * 
         * @param argTeamName String value for the name of the team
         */
        public Builder(String argTeamName) {
            teamName = argTeamName;
        }

        public Builder gamesPlayed(String argGamesPlayed) {
            gamesPlayed = StatConverterHelper.generateIntegerStat(argGamesPlayed);
            return this;
        }

        public Builder timeOnIce(String argTimeOnIce) {
            timeOnIce = StatConverterHelper.generateBigDecimalStat(argTimeOnIce);
            return this;
        }

        public Builder wins(String argWins) {
            wins = StatConverterHelper.generateIntegerStat(argWins);
            return this;
        }

        public Builder losses(String argLosses) {
            losses = StatConverterHelper.generateIntegerStat(argLosses);
            return this;
        }

        public Builder overtimeLosses(String argOvertimeLosses) {
            overtimeLosses = StatConverterHelper.generateIntegerStat(argOvertimeLosses);
            return this;
        }

        public Builder nonShootoutWins(String argNonShootoutWins) {
            nonShootoutWins = StatConverterHelper.generateIntegerStat(argNonShootoutWins);
            return this;
        }

        public Builder points(String argPoints) {
            points = StatConverterHelper.generateIntegerStat(argPoints);
            return this;
        }

        public Builder pointPercentage(String argPointPercentage) {
            pointPercentage = StatConverterHelper.generateBigDecimalStat(argPointPercentage);
            return this;
        }

        public StandardTeamStats build() {
            return new StandardTeamStats(this);
        }
    }
}
