package stats;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Statistical data fetched from the basic player stats page from Hockey
 * Reference.
 * 
 * @author sldri
 *
 */
public class BasicSkaterStats implements IPlayerStats {
    public final String name;
    public final int age;
    public final String team;
    public final String position;
    public final int gamesPlayed;

    public final int goals;
    public final int assists;
    public final int points;
    public final int plusOrMinus;
    public final int penaltyInMinutes;

    public final BigDecimal pointsShared;
    public final int evenStrengthGoals;
    public final int powerPlayGoals;
    public final int shortHandGoals;
    public final int gameWinningGoals;

    public final int evenStrengthAssists;
    public final int powerPlayAssists;
    public final int shortHandAssists;
    public final int shotsOnGoal;
    public final BigDecimal shootingPercentage;

    public final int timeOnIce;
    public final int averageTimeOnIce;
    public final int blocks;
    public final int hits;

    public final int faceOffWins;
    public final int faceOffLosses;
    public final BigDecimal faceOffPercentage;

    /**
     * Basic Player Constructor
     * 
     * @param playerStats
     */
    public BasicSkaterStats(List<String> playerStats) {
        // HEADER:
        // Player,Age,Tm,Pos,GP,G,A,PTS,+/-,PIM,PS,EV,PP,SH,GW,EV,PP,SH,S,S%,TOI,ATOI,BLK,HIT,FOW,FOL,FO%,-9999
        // Sample:
        // Some Dude,31,STL,C,46,10,8,18,0,10,1.7,10,0,0,1,6,0,2,61,16.4,652,14:11,46,142,219,187,53.9,
        name = playerStats.get(0);
        age = Integer.parseInt(playerStats.get(1));
        team = playerStats.get(2);
        position = playerStats.get(3);
        gamesPlayed = Integer.parseInt(playerStats.get(4));

        goals = Integer.parseInt(playerStats.get(5));
        assists = Integer.parseInt(playerStats.get(6));
        points = Integer.parseInt(playerStats.get(7));
        plusOrMinus = Integer.parseInt(playerStats.get(8));
        penaltyInMinutes = Integer.parseInt(playerStats.get(9));

        pointsShared = BigDecimal.valueOf(Float.parseFloat(playerStats.get(10)));
        evenStrengthGoals = Integer.parseInt(playerStats.get(11));
        powerPlayGoals = Integer.parseInt(playerStats.get(12));
        shortHandGoals = Integer.parseInt(playerStats.get(13));
        gameWinningGoals = Integer.parseInt(playerStats.get(14));

        evenStrengthAssists = Integer.parseInt(playerStats.get(15));
        powerPlayAssists = Integer.parseInt(playerStats.get(16));
        shortHandAssists = Integer.parseInt(playerStats.get(17));
        shotsOnGoal = Integer.parseInt(playerStats.get(18));
        shootingPercentage = convertToBigDecimal(playerStats.get(19));

        timeOnIce = Integer.parseInt(playerStats.get(20));
        averageTimeOnIce = averageTimeOnIce(); // Replaces index 21
        blocks = Integer.parseInt(playerStats.get(22));
        hits = Integer.parseInt(playerStats.get(23));

        faceOffWins = Integer.parseInt(playerStats.get(24));
        faceOffLosses = Integer.parseInt(playerStats.get(25));
        faceOffPercentage = convertToBigDecimal(playerStats.get(26));
    }

    private int averageTimeOnIce() {
        return timeOnIce / gamesPlayed;
    }

    @Override
    public String toString() {
        return name;
    }
}
