package stats.refined;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import stats.BasePlayerStats;
import stats.BaseTeamStats;

/**
 * 
 * 
 * @author sldri
 *
 */
public class Goals {
    private static final Logger logger = LogManager.getLogger(Goals.class);

    private BigDecimal averagePlayerGoals = BigDecimal.ZERO;
    private BigDecimal medianPlayerGoals = BigDecimal.ZERO;
    private BigDecimal averagePlayerAssists = BigDecimal.ZERO;
    private BigDecimal medianPlayerAssists = BigDecimal.ZERO;

    private int[] medianGoalSample;
    private int[] medianAssistSample;

    /**
     * Constructor to create object managing all goal related stats.
     * 
     * @param team BaseTeamStats object that holds raw stats for creating goal data.
     */
    public Goals(BaseTeamStats team) {
        logger.info("Generate goal data for {}", team);

        averagePlayerGoals =
                BigDecimal.valueOf(team.getTotalGoals() / team.getTeamMembers().size());
        averagePlayerAssists =
                BigDecimal.valueOf(team.getTotalAssists() / team.getTeamMembers().size());

        medianPlayerGoals = generateMedianValue(team, "goals");
        medianPlayerAssists = generateMedianValue(team, "assists");

    }

    /**
     * Process that pulls the integer values for a given stat and generate a median
     * result.
     * 
     * @param rawTeam TeamStatsRaw object containing skaters and related stats
     * @return BigDecimal value of median goals
     */
    private BigDecimal generateMedianValue(BaseTeamStats rawTeam, String stat) {
        int[] medianValues = new int[rawTeam.getTeamMembers().size()];

        if ("goals".equals(stat)) {
            for (int i = 0; i < rawTeam.getTeamMembers().size(); i++) {
                medianValues[i] = rawTeam.getTeamMembers().get(i).getGoals();
            }
        }
        else if ("assists".equals(stat)) {
            for (int i = 0; i < rawTeam.getTeamMembers().size(); i++) {
                medianValues[i] = rawTeam.getTeamMembers().get(i).getAssists();
            }
        }
        else {
            logger.warn("No stat was identified for creating median value.");
        }
        Arrays.sort(medianValues);

        return medianResults(medianValues);
    }

    /**
     * Method that finds the median value of an array of integers and returns it as
     * a BigDecimal result.
     * 
     * @param values int array with goals scored per player from lowest to highest
     *               amount
     * @return BigDecimal value of median found in array
     */
    private BigDecimal medianResults(int[] values) {
        if (values.length % 2 == 0) {
            return BigDecimal
                    .valueOf((values[values.length / 2] + values[values.length / 2 - 1]) / 2);
        }
        else {
            return BigDecimal.valueOf(values[values.length / 2]);
        }
    }

    public BigDecimal getAveragePlayerGoals() {
        return averagePlayerGoals;
    }

    public BigDecimal getMedianPlayerGoals() {
        return medianPlayerGoals;
    }

    public BigDecimal getAveragePlayerAssists() {
        return averagePlayerAssists;
    }

    public BigDecimal getMedianPlayerAssists() {
        return medianPlayerAssists;
    }

    public int[] getMedianGoalSample() {
        return medianGoalSample;
    }

    public int[] getMedianAssistSample() {
        return medianAssistSample;
    }
}
