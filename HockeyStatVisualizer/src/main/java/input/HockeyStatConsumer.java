package input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import stats.EStatTypes;
import stats.IStats;
import stats.teams.AdvancedStat;
import stats.teams.GoalStats;
import stats.teams.PdoStats;
import stats.teams.AdvancedGoals;
import stats.teams.StandardTeamStats;

/**
 * Class for creating the stat objects and compiling them into a Map of Maps.
 */
public class HockeyStatConsumer {
    private static final Logger LOG = LogManager.getLogger(HockeyStatConsumer.class);

    /**
     * Private constructor to maintain static behavior.
     */
    private HockeyStatConsumer() {
        // Private constructor to protect from having it instantiated.
    }

    /**
     * Leverage Apache Commons library for parsing a CSV file and returning the
     * results in a Map with stat objects.
     * 
     * @param  argFileName file name to ascertain flow of construction process
     * @return             Map of maps with stat objects associated with unique
     *                     identifier
     * @throws IOException if file name is incorrect or non-existent
     */
    public static Map<String, Map<EStatTypes, IStats>> parseStats(String argFileName)
            throws IOException {
        Map<String, Map<EStatTypes, IStats>> teamStats = new HashMap<>();

        try (BufferedReader input = new BufferedReader(new FileReader(argFileName))) {
            CSVFormat csvRaw = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .setAllowMissingColumnNames(true)
                    .build();

            Iterable<CSVRecord> records = csvRaw.parse(input);

            for (CSVRecord team : records) {
                Map<EStatTypes, IStats> elementStats = new EnumMap<>(EStatTypes.class);

                LOG.info("Building stat object(s) for team: {}", team.get("Team"));

                buildStatObjects(teamStats, team, elementStats);
            }
        }
        catch (IOException e) {
            LOG.fatal("File not found, incorrect name, or not exceptable formatting.");
            e.printStackTrace();
        }
        return teamStats;
    }

    /**
     * Builds all the stat related objects associated with the team and adds them to a EnumMap.
     * 
     * @param teamStats Map object which all teams will be added to
     * @param team CSVRecord which stats are extracted from
     * @param elementStats single map with which each team stat is added to
     */
    private static void buildStatObjects(Map<String, Map<EStatTypes, IStats>> teamStats,
            CSVRecord team, Map<EStatTypes, IStats> elementStats) {
        elementStats.put(EStatTypes.STANDARD,
                new StandardTeamStats.Builder(team.get("Team")).gamesPlayed(team.get("GP"))
                        .timeOnIce(team.get("TOI"))
                        .wins(team.get("W"))
                        .losses(team.get("L"))
                        .overtimeLosses(team.get("OTL"))
                        .nonShootoutWins(team.get("ROW"))
                        .points(team.get("Points"))
                        .pointPercentage(team.get("Point %"))
                        .build());

        elementStats.put(EStatTypes.CORSI,
                new AdvancedStat(team.get("CF"), team.get("CA"), team.get("CF%")));

        elementStats.put(EStatTypes.FENWICK,
                new AdvancedStat(team.get("FF"), team.get("FA"), team.get("FF%")));

        elementStats.put(EStatTypes.SHOTS,
                new AdvancedStat(team.get("SF"), team.get("SA"), team.get("SF%")));

        elementStats.put(EStatTypes.GOALS,
                new GoalStats.Builder(team.get("GF"), team.get("GA"), team.get("GF%"))
                        .expectedGoalsFor(team.get("xGF"))
                        .expectedGoalsAgainst(team.get("xGA"))
                        .expectedGoalsForPercentage(team.get("xGF%"))
                        .build());

        elementStats.put(EStatTypes.SCORING_CHANCES,
                new AdvancedStat(team.get("SCF"), team.get("SCA"), team.get("SCF%")));

        elementStats.put(EStatTypes.SCORING_CHANCE_SHOTS,
                new AdvancedStat(team.get("SCSF"), team.get("SCSA"), team.get("SCSF%")));

        elementStats.put(EStatTypes.SCORING_CHANCE_GOALS,
                new AdvancedGoals.Builder(team.get("SCGF"), team.get("SCGA"), team.get("SCGF%"))
                        .scoringChanceGoalsThatScored(team.get("SCSH%"))
                        .scoringChanceGoalsNotScored(team.get("SCSV%"))
                        .build());

        elementStats.put(EStatTypes.HIGH_DANGER_SCORING_CHANCES,
                new AdvancedStat(team.get("HDCF"), team.get("HDCA"), team.get("HDCF%")));

        elementStats.put(EStatTypes.HIGH_DANGER_SHOTS,
                new AdvancedStat(team.get("HDSF"), team.get("HDSA"), team.get("HDSF%")));

        elementStats.put(EStatTypes.HIGH_DANGER_GOALS,
                new AdvancedGoals.Builder(team.get("HDGF"), team.get("HDGA"), team.get("HDGF%"))
                        .scoringChanceGoalsThatScored(team.get("HDSH%"))
                        .scoringChanceGoalsNotScored(team.get("HDSV%"))
                        .build());

        elementStats.put(EStatTypes.MEDIUM_DANGER_SCORING_CHANCES,
                new AdvancedStat(team.get("MDCF"), team.get("MDCA"), team.get("MDCF%")));

        elementStats.put(EStatTypes.MEDIUM_DANGER_SHOTS,
                new AdvancedStat(team.get("MDSF"), team.get("MDSA"), team.get("MDSF%")));

        elementStats.put(EStatTypes.MEDIUM_DANGER_GOALS,
                new AdvancedGoals.Builder(team.get("MDGF"), team.get("MDGA"), team.get("MDGF%"))
                        .scoringChanceGoalsThatScored(team.get("MDSH%"))
                        .scoringChanceGoalsNotScored(team.get("MDSV%"))
                        .build());

        elementStats.put(EStatTypes.LOW_DANGER_SCORING_CHANCES,
                new AdvancedStat(team.get("LDCF"), team.get("LDCA"), team.get("LDCF%")));

        elementStats.put(EStatTypes.LOW_DANGER_SHOTS,
                new AdvancedStat(team.get("LDSF"), team.get("LDSA"), team.get("LDSF%")));

        elementStats.put(EStatTypes.LOW_DANGER_GOALS,
                new AdvancedGoals.Builder(team.get("LDGF"), team.get("LDGA"), team.get("LDGF%"))
                        .scoringChanceGoalsThatScored(team.get("LDSH%"))
                        .scoringChanceGoalsNotScored(team.get("LDSV%"))
                        .build());
        
        elementStats.put(EStatTypes.PDO, new PdoStats(team.get("SH%"), team.get("SV%"), team.get("PDO")));

        teamStats.put(team.get("Team"), elementStats);
    }
}
