package stats;

public enum EStatistics {
    /* Basic Skater Statistics */
    G("goals"),
    A("assists"),
    PTS("points"),
    
    PLUS_OR_MINUS("plus or minus"),
    PIM("penalty in minutes"),
    PTS_SHARED("points shared"),
    
    ES_GOALS("even strength goals"),
    PP_GOALS("power play goals"),
    GAME_WINNING_GOALS("game winning goals"),
    
    ES_ASSISTS("even strength assists"),
    PP_ASSISTS("power play assists"),
    SH_ASSISTS("short hand assists"),
    
    SOG("shots on goal"),
    SHOOTING_PERC("shooting percentage"),
    TOI("time on ice"),
    AVG_TOI("average time on ice"),
    
    BLOCKS("blocks"),
    FO_WINS("face off wins"),
    FO_LOSSES("face off losses"),
    FO_PERCENTAGE("face off percentage"),
    
    /* Advanced Skater Statistics */
    CF("Corsi for at Even Strength"),
    CA("Corsi against at Even Strength"),
    CF_PERC_AT_ES("Corsi percent for at even strength"),
    REL_CF_AT_ES("relative Corsi at even strength"),
    
    FF("Fenwick for at even strength"),
    FA("Fenwich against at even strength"),
    FF_PERC_AT_ES("Fenwich percent for at even strength"),
    REL_FF_FOR_PERC("relative Fenwich for percentage"),
    
    TM_ON_ICE_SHOOTING_PERC("team on ice shooting percentage"),
    TM_ON_ICE_SAVE_PERC("team on ice save percentage"),
    PDO("PDO"),
    
    OFF_ZONE_START_PERC("offensive zone start percentage"),
    DEF_ZONE_START_PERC("definsive zone start percentage"),
    
    TOI_ALL_SIT("time on ice all situations"),
    TOI_ES("time on ice even strength"),
    
    TAKEAWAYS("takeaways"),
    GIVEAWAYS("giveaways"),
    
    EXPECTED_PLUS_OR_MINUS("expected plus or minus"),
    TOTAL_SHOTS("total shots attempted in all situations"),
    PERC_OF_SHOTS_ON_NET("percentage of shots taken that go on net"),
    
    /* Goalie Statistics */
    W("wins"),
    L("losses"),
    OT("overtime losses"),
    GA("goals against"),
    SA("shots against"),
    
    SAVES("saves"),
    SAVE_PERC("save percentage"),
    GAA("goals against average"),
    SHUTOUTS("shutouts"),
    
    GOALIE_PTS_SHARED("goalie points shared"),
    MIN("minutes"),
    QUAL_STARTS("quality starts"),
    BAD_STARTS("bad starts"),
    GA_PERC("goals allowed percentage"),
    
    /* Team Standings */
    OVERALL("overall"),
    SO("shootout"),
    HOME("home"),
    ROAD("road"),
    
    EAST("Eastern"),
    WEST("Western"),
    ATL("Atlantic"),
    METRO("Metropolis"),
    CENT("Central"),
    PAC("Pacific"),
    
    ONE_OR_FEWER("games decided by one or fewer goals"),
    THREE_OR_GREATER("games decided by three or more goals"),
    
    OCT("October"),
    NOV("November"),
    DEC("Decemeber"),
    JAN("January"),
    FEB("February"),
    MAR("March"),
    APR("April"),
    
    BASIC_STATS("basic stats"),
    ADVANCE_STATS("advance stats"),
    GOALIE_STATS("goalie stats");
    
    EStatistics(String statType) {
        this.statistic = statType;
    }
    private final String statistic;
}
