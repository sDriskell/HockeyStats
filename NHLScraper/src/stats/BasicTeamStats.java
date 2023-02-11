package stats;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class BasicTeamStats {
    private static final Logger logger = LogManager.getLogger(BasicTeamStats.class);

    private int totalGoals;
    private int totalAssists;
    private int totalShotsOnGoal;
    private int totalPowerPlayAssists;
    private int totalPowerPlayGoals;
    private int totalEvenStrengthAssists;
    private int totalEvenStrengthGoals;
    
    private int totalPlusOrMinus;
    private int totalPoints;
    private BigDecimal totalPointsShared = BigDecimal.ZERO;
    
    private int totalBlocks;
    private int totalHits;
    private int totalPenaltyInMinutes;
    private BigDecimal totalShootingPercentage = BigDecimal.ZERO;
    
    private int totalTimeOnIce;
    private int averagePlayerTimeOnIce;
    private BigDecimal faceOffPercentage = BigDecimal.ZERO;
    private int faceOffWins;
    
    private List<BasicSkaterStats> teamMembers;
    private String teamName;

    /**
     * Constructor for making a team object with team related stats
     * 
     * @param argTeamName    is a String name of the team
     * @param argTeamMembers is a list of team members on the team
     */
    public BasicTeamStats(String argTeamName, List<BasicSkaterStats> argTeamMembers) {
        logger.info("Generating team statistics.");
        teamName = argTeamName;
        teamMembers = argTeamMembers;

        tallyTeamStats();
    }

    /**
     * Creates all the total values of the team stats
     */
    private void tallyTeamStats() {
        for (BasicSkaterStats player : teamMembers) {
            totalGoals += player.goals;
            totalAssists += player.assists;
            totalShotsOnGoal += player.shotsOnGoal;
            totalPowerPlayAssists += player.powerPlayAssists;
            totalPowerPlayGoals += player.powerPlayGoals;
            totalEvenStrengthAssists += player.evenStrengthAssists;
            totalEvenStrengthGoals += player.evenStrengthGoals;
            
            totalPlusOrMinus += player.plusOrMinus;
            totalPoints += player.points;
            totalPointsShared = totalPointsShared.add(player.pointsShared);
            
            totalShootingPercentage = totalShootingPercentage.add(player.shootingPercentage);
            totalBlocks += player.blocks;
            totalHits += player.hits;
            totalPenaltyInMinutes += player.penaltyInMinutes;
            
            totalTimeOnIce += player.timeOnIce;
            averagePlayerTimeOnIce += player.averageTimeOnIce;
            faceOffPercentage = faceOffPercentage.add(player.faceOffPercentage);
            faceOffWins += player.faceOffWins;
        }

        // Smooth two stat fields over so they're an appropriate percentage
        smoothStats();
    }

    /**
     * Divides the statistics by team size to get the appropriate cumulative value
     * for those stats.
     */
    private void smoothStats() {
        averagePlayerTimeOnIce = averagePlayerTimeOnIce / teamMembers.size();
        totalShootingPercentage =
                totalShootingPercentage.divide(new BigDecimal(teamMembers.size()), 2, RoundingMode.HALF_UP);
    }

    public List<BasicSkaterStats> getTeamMembers() {
        return teamMembers;
    }

    public int getTotalGoals() {
        return totalGoals;
    }

    public int getTotalAssists() {
        return totalAssists;
    }

    public int getTotalShotsOnGoal() {
        return totalShotsOnGoal;
    }

    public int getTotalPowerPlayAssists() {
        return totalPowerPlayAssists;
    }

    public int getTotalPowerPlayGoals() {
        return totalPowerPlayGoals;
    }

    public int getTotalEvenStrengthAssists() {
        return totalEvenStrengthAssists;
    }

    public int getTotalEvenStrengthGoals() {
        return totalEvenStrengthGoals;
    }

    public int getTotalPlusOrMinus() {
        return totalPlusOrMinus;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public BigDecimal getTotalPointsShared() {
        return totalPointsShared;
    }

    public int getTotalBlocks() {
        return totalBlocks;
    }

    public int getTotalHits() {
        return totalHits;
    }

    public int getTotalPenaltyInMinutes() {
        return totalPenaltyInMinutes;
    }

    public BigDecimal getTotalShootingPercentage() {
        return totalShootingPercentage;
    }

    public int getTotalTimeOnIce() {
        return totalTimeOnIce;
    }

    public int getAveragePlayerTimeOnIce() {
        return averagePlayerTimeOnIce;
    }

    public BigDecimal getFaceOffPercentage() {
        return faceOffPercentage;
    }

    public int getFaceOffWins() {
        return faceOffWins;
    }

    public String toString() {
        return teamName;
    }
}
