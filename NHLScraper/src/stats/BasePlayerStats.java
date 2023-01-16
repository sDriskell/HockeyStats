package stats;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasePlayerStats {
    private final int rank;
    
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

    public BasePlayerStats(List<String> argNhlPlayerStats) {
        rank = Integer.parseInt(argNhlPlayerStats.get(0));
        
        name = trimNameString(argNhlPlayerStats.get(1));
        age = Integer.parseInt(argNhlPlayerStats.get(2));
        team = argNhlPlayerStats.get(3);
        position = argNhlPlayerStats.get(4);
        gamesPlayed = Integer.parseInt(argNhlPlayerStats.get(5));
        
        goals = Integer.parseInt(argNhlPlayerStats.get(6));
        assists = Integer.parseInt(argNhlPlayerStats.get(7));
        points = Integer.parseInt(argNhlPlayerStats.get(8));
        plusOrMinus = Integer.parseInt(argNhlPlayerStats.get(9));
        penaltyInMinutes = Integer.parseInt(argNhlPlayerStats.get(10));
        
        pointsShared = BigDecimal.valueOf(Float.parseFloat(argNhlPlayerStats.get(11)));
        evenStrengthGoals = Integer.parseInt(argNhlPlayerStats.get(12));
        powerPlayGoals = Integer.parseInt(argNhlPlayerStats.get(13));
        shortHandGoals = Integer.parseInt(argNhlPlayerStats.get(14));
        gameWinningGoals = Integer.parseInt(argNhlPlayerStats.get(15));
        
        evenStrengthAssists = Integer.parseInt(argNhlPlayerStats.get(16));
        powerPlayAssists = Integer.parseInt(argNhlPlayerStats.get(17));
        shortHandAssists = Integer.parseInt(argNhlPlayerStats.get(18));
        shotsOnGoal = Integer.parseInt(argNhlPlayerStats.get(19));
        shootingPercentage = "".equals(argNhlPlayerStats.get(20)) ? BigDecimal.ZERO
                : BigDecimal.valueOf(Float.parseFloat(argNhlPlayerStats.get(20)));
        
        timeOnIce = Integer.parseInt(argNhlPlayerStats.get(21));
        averageTimeOnIce = averageTimeOnIce();
        blocks = Integer.parseInt(argNhlPlayerStats.get(23));
        hits = Integer.parseInt(argNhlPlayerStats.get(24));
        
        faceOffWins = Integer.parseInt(argNhlPlayerStats.get(25));
        faceOffLosses = Integer.parseInt(argNhlPlayerStats.get(26));
        faceOffPercentage = "".equals(argNhlPlayerStats.get(27)) ? BigDecimal.ZERO:
            BigDecimal.valueOf(Float.parseFloat(argNhlPlayerStats.get(27)));
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

    public int getRank() {
        return rank;
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
