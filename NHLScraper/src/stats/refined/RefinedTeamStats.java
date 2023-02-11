package stats.refined;

import java.math.BigDecimal;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import stats.BasicSkaterStats;
import stats.BasicTeamStats;

/**
 * Refines stats captured by TeamStatsRaw.class to create more detailed data on
 * team and players.
 * 
 * @author sldri
 *
 */
public class RefinedTeamStats {
    private static final Logger logger = LogManager.getLogger(RefinedTeamStats.class);
    
    private BasicTeamStats baseTeamStats;
    private Scoring goals;

    public RefinedTeamStats(BasicTeamStats baseTeamStats) {
        this.baseTeamStats = baseTeamStats;
        
        goals = new Scoring(baseTeamStats);
    }
    
    public BasicTeamStats getRawTeamStats() {
        return baseTeamStats;
    }
    
    public Scoring getGoals() {
        return goals;
    }
    
    public String toString() {
        return baseTeamStats.toString();
    }
}
