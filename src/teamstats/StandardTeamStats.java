package teamstats;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import helpers.StatConverterHelper;

public class StandardTeamStats {
    private static final Logger LOG = LogManager.getLogger(StandardTeamStats.class);

    private static final int EXPECTED_LENGTH_OF_ARG = 8;
    private static final int SEASON_GAMES = 82;

    private Integer gamesPlayed;
    private Integer wins;
    private Integer losses;
    private Integer overtimeLosses;
    private Integer nonShootOutWins;
    private Integer seasonPoints;
    
    private BigDecimal seasonPointPercentage;
    private BigDecimal timeOnIce;


    public StandardTeamStats(String[] argStandardStats) throws ArrayIndexOutOfBoundsException {
        if (argStandardStats.length < EXPECTED_LENGTH_OF_ARG) {
            LOG.fatal("Incorrect array/stat size for standard stats.");
            throw new ArrayIndexOutOfBoundsException();
        }

        gamesPlayed = StatConverterHelper.generateIntegerStat(argStandardStats[0]);
        timeOnIce = StatConverterHelper.generateBigDecimalStat(argStandardStats[1]);
        wins = StatConverterHelper.generateIntegerStat(argStandardStats[2]);
        losses = StatConverterHelper.generateIntegerStat(argStandardStats[3]);
        
        overtimeLosses = StatConverterHelper.generateIntegerStat(argStandardStats[4]);
        nonShootOutWins = StatConverterHelper.generateIntegerStat(argStandardStats[5]);
        seasonPoints = StatConverterHelper.generateIntegerStat(argStandardStats[6]);
        seasonPointPercentage = StatConverterHelper.generateBigDecimalStat(argStandardStats[7]);
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

    public int getNonShootOutWins() {
        return nonShootOutWins;
    }

    public Integer getSeasonPoints() {
        return seasonPoints;
    }

    public BigDecimal getSeasonPointPercentage() {
        return seasonPointPercentage;
    }

}
