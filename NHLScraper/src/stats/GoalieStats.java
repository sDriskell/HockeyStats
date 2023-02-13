package stats;

import java.math.BigDecimal;
import java.util.List;

//Player,Age,Tm,GP,GS,W,L,T/O,GA,SA,SV,SV%,GAA,SO,GPS,MIN,QS,QS%,RBS,GA%-,GSAA,G,A,PTS,PIM
//Jordan Binnington,29,STL,40,40,19,18,3,127,1158,1031,.890,3.31,2,4.7,2299,17,.425,10,116,-17.89,0,1,1,10
public class GoalieStats implements IPlayerStats {
    public final String name;
    public final int age;
    public final String team;
    public final int gamesPlayed;
    public final int gamesStarted;
    
    public final int wins;
    public final int losses;
    public final int overtimeLosses;
    
    public final int goalsAgainst;
    public final int shotsAgainst;
    public final int saves;
    
    public final BigDecimal savePercentage;
    public final BigDecimal goalsAgainstAverage;
    public final int shutouts;
    public final BigDecimal goaliePointsShared;
    
    public final int minutes;
    public final int qualityStarts;
    public final BigDecimal qualityStartsPercentage;
    public final int reallyBadStarts;
    
    public final int goalsAllowedPercentage;
    public final BigDecimal goalsSavedAboveAverage;
    
    public final int goals;
    public final int assists;
    public final int points;
    public final int penaltyInMinutes;
    
    public GoalieStats(List<String> goalie) {
        name = goalie.get(0);
        age = Integer.parseInt(goalie.get(1));
        team = goalie.get(2);
        gamesPlayed = Integer.parseInt(goalie.get(3));
        gamesStarted = Integer.parseInt(goalie.get(4));
        
        wins = Integer.parseInt(goalie.get(5));
        losses = Integer.parseInt(goalie.get(6));
        overtimeLosses = Integer.parseInt(goalie.get(7));
        
        goalsAgainst = Integer.parseInt(goalie.get(8));
        shotsAgainst = Integer.parseInt(goalie.get(9));
        saves = Integer.parseInt(goalie.get(10));
        
        savePercentage = convertToBigDecimal(goalie.get(11));
        goalsAgainstAverage = convertToBigDecimal(goalie.get(12));
        shutouts = Integer.parseInt(goalie.get(13));
        goaliePointsShared = convertToBigDecimal(goalie.get(14));
        
        minutes = Integer.parseInt(goalie.get(15));
        qualityStarts = Integer.parseInt(goalie.get(16));
        qualityStartsPercentage = convertToBigDecimal(goalie.get(17));
        reallyBadStarts = Integer.parseInt(goalie.get(18));
        
        goalsAllowedPercentage = Integer.parseInt(goalie.get(19));
        goalsSavedAboveAverage = convertToBigDecimal(goalie.get(20));
        
        goals = Integer.parseInt(goalie.get(21));
        assists = Integer.parseInt(goalie.get(22));
        points = Integer.parseInt(goalie.get(23));
        penaltyInMinutes = Integer.parseInt(goalie.get(24));
    }

    @Override
    public String toString() {
        return name;
    }
}
