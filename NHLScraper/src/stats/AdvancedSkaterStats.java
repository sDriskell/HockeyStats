package stats;

import java.math.BigDecimal;
import java.util.List;

//Player,Age,Tm,Pos,GP,CF,CA,CF%,CF% rel,FF,FA,FF%,FF% rel,oiSH%,oiSV%,PDO,oZS%,dZS%,TOI/60,TOI(EV),TK,GV,E+/-,SAtt.,Thru%
//Noel Acciari,31,STL,C,51,468,612,43.3,-3.7,374,437,46.1,-0.6,8.8,90.9,99.6,39.7,60.3,14:30,12:39,21,6,-0.9,111,59.5

public class AdvancedSkaterStats implements IPlayerStats {
    public final String name;
    public final int age;
    public final String team;
    public final String position;
    public final int gamesPlayed;

    public final int corsiForEvenStrength;
    public final int corsiAgainstEvenStrength;
    public final BigDecimal corsiForPercentEvenStrength;
    public final BigDecimal relativeCorsiPercentEvenStrength;

    public final int fenwichForEvenStrength;
    public final int fenwichAgainstEvenStrength;
    public final BigDecimal fenwichForPercentEvenStrength;
    public final BigDecimal relativeFenwichForPercentage;

    public final BigDecimal teamOnIceShootingPercentage;
    public final BigDecimal teamOnIceSavePercentage;
    public final BigDecimal pdo;

    public final BigDecimal offensiveZoneStartPercentage;
    public final BigDecimal defensiveZoneStartPercentage;

    public final String timeOnIceAllSituations;
    public final String timeOnIceEvenStrength;
    public final int takeaways;
    public final int giveaways;

    public final BigDecimal expectedPlusOrMinus;
    public final int totalShotsAttempted;
    public final BigDecimal percentageOfShotsOnNet;

    public AdvancedSkaterStats(List<String> playerStats) {
        name = playerStats.get(0);
        age = handleInteger(playerStats.get(1));
        team = playerStats.get(2);
        position = playerStats.get(3);
        gamesPlayed = handleInteger(playerStats.get(4));

        corsiForEvenStrength = handleInteger(playerStats.get(5));
        corsiAgainstEvenStrength = handleInteger(playerStats.get(6));
        corsiForPercentEvenStrength = convertToBigDecimal(playerStats.get(7));
        relativeCorsiPercentEvenStrength = convertToBigDecimal(playerStats.get(8));

        fenwichForEvenStrength = handleInteger(playerStats.get(9));
        fenwichAgainstEvenStrength = handleInteger(playerStats.get(10));
        fenwichForPercentEvenStrength = convertToBigDecimal(playerStats.get(11));
        relativeFenwichForPercentage = convertToBigDecimal(playerStats.get(12));

        teamOnIceShootingPercentage = convertToBigDecimal(playerStats.get(13));
        teamOnIceSavePercentage = convertToBigDecimal(playerStats.get(14));
        pdo = convertToBigDecimal(playerStats.get(15));
        offensiveZoneStartPercentage = convertToBigDecimal(playerStats.get(16));
        defensiveZoneStartPercentage = convertToBigDecimal(playerStats.get(17));

        timeOnIceAllSituations = playerStats.get(18);
        timeOnIceEvenStrength = playerStats.get(19);
        takeaways = handleInteger(playerStats.get(20));
        giveaways = handleInteger(playerStats.get(21));

        expectedPlusOrMinus = convertToBigDecimal(playerStats.get(22));
        totalShotsAttempted = handleInteger(playerStats.get(23));
        percentageOfShotsOnNet = convertToBigDecimal(playerStats.get(24));
    }

    @Override
    public String toString() {
        return name;
    }
}
