package stats;

import java.math.BigDecimal;

public interface IPlayerStats {

    /**
     * Parses String object of percentage value into a BigDecimal.
     * 
     * @param playerStat List of players stats
     * @param index      point in List to pull percentage stat
     * @return BigDecimal value of percent
     */
    default BigDecimal convertToBigDecimal(String playerStat) {
        return "".equals(playerStat) ? BigDecimal.ZERO : BigDecimal.valueOf(Float.parseFloat(playerStat));
    }

    @Override
    public String toString();
}
