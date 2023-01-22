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
public class BasePlayerStats {
    private final String name;
    private final int age;
    private final String team;
    private final String position;
    private final int gamesPlayed;

    private final int goals;
    private final int assists;
    private final int points;
    private final int plusOrMinus;
    private final int penaltyInMinutes;

    private final BigDecimal pointsShared;
    private final int evenStrengthGoals;
    private final int powerPlayGoals;
    private final int shortHandGoals;
    private final int gameWinningGoals;

    private final int evenStrengthAssists;
    private final int powerPlayAssists;
    private final int shortHandAssists;
    private final int shotsOnGoal;
    private final BigDecimal shootingPercentage;

    private final int timeOnIce;
    private final int averageTimeOnIce;
    private final int blocks;
    private final int hits;

    private final int faceOffWins;
    private final int faceOffLosses;
    private final BigDecimal faceOffPercentage;

    /**
     * Basic Player Constructor
     * 
     * @param argNhlPlayerStats
     */
    public BasePlayerStats(List<String> argNhlPlayerStats) {
        // HEADER:
        // Player,Age,Tm,Pos,GP,G,A,PTS,+/-,PIM,PS,EV,PP,SH,GW,EV,PP,SH,S,S%,TOI,ATOI,BLK,HIT,FOW,FOL,FO%,-9999
        // Sample:
        // [Player_Name],31,STL,C,46,10,8,18,0,10,1.7,10,0,0,1,6,0,2,61,16.4,652,14:11,46,142,219,187,53.9,
        name = trimNameString(argNhlPlayerStats.get(0));
        age = Integer.parseInt(argNhlPlayerStats.get(1));
        team = argNhlPlayerStats.get(2);
        position = argNhlPlayerStats.get(3);
        gamesPlayed = Integer.parseInt(argNhlPlayerStats.get(4));

        goals = Integer.parseInt(argNhlPlayerStats.get(5));
        assists = Integer.parseInt(argNhlPlayerStats.get(6));
        points = Integer.parseInt(argNhlPlayerStats.get(7));
        plusOrMinus = Integer.parseInt(argNhlPlayerStats.get(8));
        penaltyInMinutes = Integer.parseInt(argNhlPlayerStats.get(9));

        pointsShared = BigDecimal.valueOf(Float.parseFloat(argNhlPlayerStats.get(10)));
        evenStrengthGoals = Integer.parseInt(argNhlPlayerStats.get(11));
        powerPlayGoals = Integer.parseInt(argNhlPlayerStats.get(12));
        shortHandGoals = Integer.parseInt(argNhlPlayerStats.get(13));
        gameWinningGoals = Integer.parseInt(argNhlPlayerStats.get(14));

        evenStrengthAssists = Integer.parseInt(argNhlPlayerStats.get(15));
        powerPlayAssists = Integer.parseInt(argNhlPlayerStats.get(16));
        shortHandAssists = Integer.parseInt(argNhlPlayerStats.get(17));
        shotsOnGoal = Integer.parseInt(argNhlPlayerStats.get(18));
        shootingPercentage = "".equals(argNhlPlayerStats.get(19)) ? BigDecimal.ZERO
                : BigDecimal.valueOf(Float.parseFloat(argNhlPlayerStats.get(19)));

        timeOnIce = Integer.parseInt(argNhlPlayerStats.get(20));
        averageTimeOnIce = averageTimeOnIce();  // Replaces index 21
        blocks = Integer.parseInt(argNhlPlayerStats.get(22));
        hits = Integer.parseInt(argNhlPlayerStats.get(23));

        faceOffWins = Integer.parseInt(argNhlPlayerStats.get(24));
        faceOffLosses = Integer.parseInt(argNhlPlayerStats.get(25));
        faceOffPercentage = "".equals(argNhlPlayerStats.get(26)) ? BigDecimal.ZERO
                : BigDecimal.valueOf(Float.parseFloat(argNhlPlayerStats.get(26)));
    }

    /**
     * Trims the excess from the name starting at char '\' and all else till end of
     * String.
     * 
     * @param argName String name to be trimmed
     * @return String name trimmed to just name
     */
    private String trimNameString(String argName) {
        StringBuilder tempNameString = new StringBuilder();

        for (int i = 0; i < argName.length(); i++) {
            if (argName.charAt(i) == '\\') {
                break;
            }
            tempNameString.append(argName.charAt(i));
        }
        return tempNameString.toString();
    }

    private int averageTimeOnIce() {
        return timeOnIce / gamesPlayed;
    }

    public int getAge() {
        return age;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getPoints() {
        return points;
    }

    public int getPlusOrMinus() {
        return plusOrMinus;
    }

    public int getPenaltyInMinutes() {
        return penaltyInMinutes;
    }

    public BigDecimal getPointsShared() {
        return pointsShared;
    }

    public int getEvenStrengthGoals() {
        return evenStrengthGoals;
    }

    public int getPowerPlayGoals() {
        return powerPlayGoals;
    }

    public int getShortHandGoals() {
        return shortHandGoals;
    }

    public int getGameWinningGoals() {
        return gameWinningGoals;
    }

    public int getEvenStrengthAssists() {
        return evenStrengthAssists;
    }

    public int getPowerPlayAssists() {
        return powerPlayAssists;
    }

    public int getShortHandAssists() {
        return shortHandAssists;
    }

    public int getShotsOnGoal() {
        return shotsOnGoal;
    }

    public BigDecimal getShootingPercentage() {
        return shootingPercentage;
    }

    public int getTimeOnIce() {
        return timeOnIce;
    }

    public int getAverageTimeOnIce() {
        return averageTimeOnIce;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getHits() {
        return hits;
    }

    public int getFaceOffWins() {
        return faceOffWins;
    }

    public int getFaceOffLosses() {
        return faceOffLosses;
    }

    public BigDecimal getFaceOffPercentage() {
        return faceOffPercentage;
    }

    @Override
    public String toString() {
        return name;
    }
}
