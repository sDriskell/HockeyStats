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
    
    /**
     * Checks to ensure stat has an appropriate Integer value from string argument.
     * 
     * @param playerStat is the String object with player stat to be inspect
     * @return Integer type for stat parsed from String object
     */
    default Integer handleInteger(String playerStat) {
        return "".equals(playerStat) ? 0 : Integer.parseInt(playerStat);
    }

    @Override
    public String toString();
}
