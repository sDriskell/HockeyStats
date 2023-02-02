package stats.refined;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import stats.BasicPlayerStats;
import stats.BaseTeamStats;

/**
 * Refines stats captured by TeamStatsRaw.class to create more detailed data on
 * team and players.
 * 
 * @author sldri
 *
 */
public class RefinedTeamStats {
    private static final Logger logger = LogManager.getLogger(RefinedTeamStats.class);
    
    private BaseTeamStats baseTeamStats;
    private Goals goals;

    public RefinedTeamStats(BaseTeamStats baseTeamStats) {
        this.baseTeamStats = baseTeamStats;
        
        goals = new Goals(baseTeamStats);
    }
    
    public BaseTeamStats getRawTeamStats() {
        return baseTeamStats;
    }
    
    public Goals getGoals() {
        return goals;
    }
    
    public String toString() {
        return baseTeamStats.toString();
    }
}
