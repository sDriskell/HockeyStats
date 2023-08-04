package helpers;

import java.math.BigDecimal;

/**
 * Helper class to handle the stat conversions from String to numerical value.
 * Used for multiple stat types.
 */
public final class StatConverterHelper {
    private StatConverterHelper() {
        // Empty constructor for Helper class
    }
    
    public static BigDecimal generateBigDecimalStat(String argStat) {
        return argStat == null ? BigDecimal.ZERO : BigDecimal.valueOf(Double.parseDouble(argStat));
    }

    public static Integer generateIntegerStat(String argStat) {
        return argStat == null || "".equals(argStat) ? Integer.parseInt("0") : Integer.parseInt(argStat);
    }
}
