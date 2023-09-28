package stats.teams;

import java.math.BigDecimal;

import helpers.StatConverterHelper;
import stats.IStats;

/**
 * PDO related stats for teams.
 */
public class PdoStats implements IStats {
    private BigDecimal shotPercentageGoalsFor;
    private BigDecimal shotPercentageNotGoalsAgainst;
    private BigDecimal pdo;

    /**
     * PDO Stat Constructor
     * 
     * @param argShotsPercentageGoalsFor       String value for percentage of shots
     *                                         that were goals for.
     * @param argShotPercentageNotGoalsAgainst String value for percentage of shots
     *                                         that were not goals against.
     * @param argPdo                           String value for PDO
     */
    public PdoStats(String argShotsPercentageGoalsFor, String argShotPercentageNotGoalsAgainst,
            String argPdo) {
        shotPercentageGoalsFor =
                StatConverterHelper.generateBigDecimalStat(argShotsPercentageGoalsFor);
        shotPercentageNotGoalsAgainst =
                StatConverterHelper.generateBigDecimalStat(argShotPercentageNotGoalsAgainst);
        pdo = StatConverterHelper.generateBigDecimalStat(argPdo);
    }

    public BigDecimal getShotPercentageGoalsFor() {
        return shotPercentageGoalsFor;
    }

    public BigDecimal getShotPercentageNotGoalsAgainst() {
        return shotPercentageNotGoalsAgainst;
    }

    public BigDecimal getPdo() {
        return pdo;
    }
}
