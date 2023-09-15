package helpers;

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatConverterHelper {
    private static final Logger LOG = LogManager.getLogger(StatConverterHelper.class);

    private static final Integer STANDARD_TIME_OF_PLAY = 60;

    private StatConverterHelper() {
        // This is an empty constructor to mask for a helper class.
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

        return new BigDecimal(argStat * STANDARD_TIME_OF_PLAY).divide(argTimeOnIce);
    }
}
