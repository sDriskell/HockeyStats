package stats;

public enum Statistics {
    GOALS("goals"),
    ASSISTS("assists"),
    POINTS("points"),
    
    PLUS_OR_MINUS("plus or minus"),
    PENALTY_IN_MINUTES("penalty in minutes"),
    POINTS_SHARED("points shared"),
    
    EVEN_STRENGTH_GOALS("even strength goals"),
    POWER_PLAY_GOALS("power play goals"),
    GAME_WINNING_GOALS("game winning goals"),
    
    EVEN_STRENGTH_ASSISTS("even strength assists"),
    POWER_PLAY_ASSISTS("power play assists"),
    SHORT_HAND_ASSISTS("short hand assists"),
    
    SHOTS_ON_GOAL("shots on goal"),
    SHOOTING_PERCENTAGE("shooting percentage"),
    TIME_ON_ICE("time on ice"),
    AVERAGE_TIME_ON_ICE("average time on ice"),
    
    BLOCKS("blocks"),
    FACE_OFF_WINS("face off wins"),
    FACE_OFF_LOSSES("face off losses"),
    FACE_OFF_PERCENTAGE("face off percentage");
    
    Statistics(String statType) {
        this.statistic = statType;
    }
    private final String statistic;
}
