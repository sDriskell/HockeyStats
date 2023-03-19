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
        age = handleInteger(goalie.get(1));
        team = goalie.get(2);
        gamesPlayed = handleInteger(goalie.get(3));
        gamesStarted = handleInteger(goalie.get(4));

        wins = handleInteger(goalie.get(5));
        losses = handleInteger(goalie.get(6));
        overtimeLosses = handleInteger(goalie.get(7));

        goalsAgainst = handleInteger(goalie.get(8));
        shotsAgainst = handleInteger(goalie.get(9));
        saves = handleInteger(goalie.get(10));

        savePercentage = convertToBigDecimal(goalie.get(11));
        goalsAgainstAverage = convertToBigDecimal(goalie.get(12));
        shutouts = handleInteger(goalie.get(13));
        goaliePointsShared = convertToBigDecimal(goalie.get(14));

        minutes = handleInteger(goalie.get(15));
        qualityStarts = handleInteger(goalie.get(16));
        qualityStartsPercentage = convertToBigDecimal(goalie.get(17));
        reallyBadStarts = handleInteger(goalie.get(18));

        goalsAllowedPercentage = handleInteger(goalie.get(19));
        goalsSavedAboveAverage = convertToBigDecimal(goalie.get(20));

        goals = handleInteger(goalie.get(21));
        assists = handleInteger(goalie.get(22));
        points = handleInteger(goalie.get(23));
        penaltyInMinutes = handleInteger(goalie.get(24));
    }

    @Override
    public String toString() {
        return name;
    }
}
