package helpers;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Helper class to handle the stat conversions from String to numerical value.
 * Used for multiple stat types.
 */
public final class StatConverterHelper {
    private static final Logger LOG = LogManager.getLogger(StatConverterHelper.class);

    private static final Integer TIME_OF_PLAY = 60;

    private StatConverterHelper() {
        // Empty constructor for Helper class
    }

    /**
     * Takes String argument of stat and creates it into a BigDecimal format.
     * 
     * @param argStat String object with value needed to convert to BigDecimal
     * @return stat in BigDecimal format
     */
    public static BigDecimal generateBigDecimalStat(String argStat) {
        return argStat == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(argStat));
    }

    /**
     * Create Integer wrapper object from String stat provided.
     * 
     * @param argStat String to be converted to Integer wrapper object
     * @return Integer wrapper object of stat
     */
    public static Integer generateIntegerStat(String argStat) {
        return argStat == null || "".equals(argStat) ? Integer.parseInt("0")
                : Integer.parseInt(argStat);
    }

    /**
     * Calculates the stat value provided into a measurement over 60 minutes of
     * play-time.
     * 
     * @param argStat      BigDecimal object of stat to be measured over 60 minutes
     * @param argTimeOnIce Integer stat object for time spent on ice
     * @return BigDecimal object showing per60 of stat
     */
    public static BigDecimal perSixtyMinutesOfPlay(Integer argStat, BigDecimal argTimeOnIce) {
        if (argStat == null || argTimeOnIce == null) {
            LOG.error("One of two arguments is null. argStat={} or argTimeOnIce={}", argStat,
                    argTimeOnIce);
            return BigDecimal.ZERO;
        }

        return new BigDecimal(argStat * TIME_OF_PLAY).divide(argTimeOnIce);
    }
}
